package com.mongo.demo.mongodemo.dao;

import com.mongo.demo.mongodemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


/**
 * 用户数据库操作
 *
 * @author hejq
 * @date 2019/5/28 10:54
 */
@Component
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     */
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    /**
     * 通过姓名查询用户
     *
     * @param name 用户姓名
     * @return 符合条件的用户
     */
    public UserEntity findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, UserEntity.class);
    }

    /**
     * 更新用户
     *
     * @param user 用户信息
     */
    public void updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("sex", user.getSex()).set("name", user.getName());
        mongoTemplate.updateFirst(query, update, UserEntity.class);
    }

    /**
     * 通过用户id删除用户信息
     *
     * @param userId 用户id
     */
    public void deleteById(Long userId) {
        Query query = new Query(Criteria.where("id").is(userId));
        mongoTemplate.remove(query, UserEntity.class);
    }
}
