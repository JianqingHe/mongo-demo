package com.mongo.demo.mongodemo.dao;

import com.mongo.demo.mongodemo.core.PageInfo;
import com.mongo.demo.mongodemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;


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

    /**
     * 通过分页信息搜索用户数据
     *
     * @param page 分页信息
     * @return 分页返回用户数据
     */
    public PageInfo<UserEntity> findByPageInfo(PageInfo page) {
        Query query = new Query();
        query.with(page.getOrders());
        int skip = (page.getPage() - 1) * page.getSize();
        Pattern pattern = Pattern.compile("^.*" + page.getKeyword() + ".*$", Pattern.CASE_INSENSITIVE);
        Criteria criteria = Criteria.where("name").regex(pattern);
        query.addCriteria(criteria);
        long count = mongoTemplate.count(query, UserEntity.class);
        // 从那条记录开始
        query.skip(skip);
        // 取多少条记录
        query.limit(page.getSize());
        List<UserEntity> userList = mongoTemplate.find(query, UserEntity.class);
        page.setData(userList);
        page.setTotal(count);
        return page;
    }

    /**
     * 批量插入数据
     *
     * @param userList 用户数据
     */
    public void batchInsert(List<UserEntity> userList) {
        mongoTemplate.insert(userList, UserEntity.class);
    }
}
