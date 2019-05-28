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

    private Integer id;

    private String name;

    private String sex;
}
