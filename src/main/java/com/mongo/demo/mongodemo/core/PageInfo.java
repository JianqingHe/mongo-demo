package com.mongo.demo.mongodemo.core;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页参数
 *
 * @author hejq
 * @date 2019/5/28 11:37
 */
@Data
public class PageInfo<T> {

    int value = 10;

    /**
     * 分页大小
     */
    int size = 10;

    /**
     * 页码
     */
    int page = 0;

    /**
     * 排序字段
     */
    String[] sorts = {};

    /**
     * 排序规则
     */
    Sort.Direction direction = Sort.Direction.ASC;

    /**
     * 数据集合
     */
    List<T> data = new ArrayList<>();

    /**
     * 搜索关键字
     */
    String keyword;

    /**
     * 总数
     */
    long total = 0;

    public Sort getOrders() {
        return new Sort(direction, sorts);
    }
}
