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

    int size = 10;

    int page = 0;

    String[] sorts = {};

    Sort.Direction direction = Sort.Direction.ASC;

    List<T> data = new ArrayList<>();

    String keyword;

    Sort orders;

    long total = 0;

    public Sort getOrders() {
        List<Sort.Order> orders = new ArrayList<>();
        int length = sorts.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                Sort.Order order = new Sort.Order(direction, sorts[i]);
                orders.add(order);
            }
        }
        return new Sort(orders);
    }
}
