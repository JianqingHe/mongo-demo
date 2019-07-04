package com.mongo.demo.mongodemo.entity;

import lombok.Data;

/**
 * 用户
 *
 * @author hejq
 * @date 2019/5/28 10:52
 */
@Data
public class UserEntity {

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;
}
