package com.mongo.demo.mongodemo.controller;

import com.mongo.demo.mongodemo.core.ResultMap;
import com.mongo.demo.mongodemo.dao.UserDao;
import com.mongo.demo.mongodemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 *
 * @author hejq
 * @date 2019/5/28 10:50
 */
@RestController
@RequestMapping("/mg")
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 添加用户信息
     *
     * @param userEntity 用户信息
     * @return 操作结果
     */
    @PostMapping("/addUser")
    public ResultMap saveUser(@RequestBody UserEntity userEntity) {
        userDao.saveUser(userEntity);
        return ResultMap.success();
    }

    /**
     * 通过用户姓名查询用户信息
     *
     * @param name 用户姓名
     * @return 用户信息
     */
    @GetMapping("/findByName")
    public ResultMap findByName(String name) {
        UserEntity user = userDao.findByName(name);
        return ResultMap.success(user);
    }

    /**
     * 更新用户信息
     *
     * @param userEntity 用户信息
     * @return 操作结果
     */
    @PostMapping("/update")
    public ResultMap updateUser(@RequestBody UserEntity userEntity) {
        userDao.updateUser(userEntity);
        return ResultMap.success();
    }

    /**
     * 通过用户id删除用户信息
     *
     * @param userId 用户id
     * @return 操作结果
     */
    @DeleteMapping("/delete/{id}")
    public ResultMap deleteById(@PathVariable("id") Long userId) {
        userDao.deleteById(userId);
        return ResultMap.success();
    }
}
