package com.mongo.demo.mongodemo.controller;

import com.mongo.demo.mongodemo.core.PageInfo;
import com.mongo.demo.mongodemo.core.ResultMap;
import com.mongo.demo.mongodemo.dao.UserDao;
import com.mongo.demo.mongodemo.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 *
 * @author hejq
 * @date 2019/5/28 10:50
 */
@RestController
@RequestMapping("/mg")
@Slf4j
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
        log.debug("单个添加用户 {}", userEntity);
        userDao.saveUser(userEntity);
        return ResultMap.success();
    }

    /**
     * 添加用户信息
     *
     * @param userList 用户信息
     * @return 操作结果
     */
    @PostMapping("/batchInsert")
    public ResultMap batchInsert(@RequestBody List<UserEntity> userList) {
        log.debug("批量添加用户 {}", userList);
        userDao.batchInsert(userList);
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
        log.debug("通过姓名查询用户 keyword->{}", name);
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
        log.debug("更新用户信息 {}", userEntity);
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
        log.debug("通过id删除用户 id->{}", userId);
        userDao.deleteById(userId);
        return ResultMap.success();
    }

    /**
     * 分页查询用户信息
     *
     * @param page 分页参数
     * @return 分页擦好像结果
     */
    @GetMapping("/page")
    public ResultMap findByPageInfo(@PageableDefault PageInfo page) {
        log.debug("分页查询用户 {}", page);
        PageInfo<UserEntity> pageInfo = userDao.findByPageInfo(page);
        return ResultMap.success(pageInfo);
    }
}
