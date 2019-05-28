package com.mongo.demo.mongodemo.core;

import lombok.Data;
import org.springframework.data.domain.Pageable;
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
public class PageInfo<T> implements Pageable {

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

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    @Override
    public int getPageNumber() {
        return this.page;
    }

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    @Override
    public int getPageSize() {
        return this.size;
    }

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken
     */
    @Override
    public long getOffset() {
        return 0;
    }

    /**
     * Returns the sorting parameters.
     *
     * @return
     */
    @Override
    public Sort getSort() {
        return this.getOrders();
    }

    /**
     * Returns the {@link Pageable} requesting the next {@link Page}.
     *
     * @return
     */
    @Override
    public Pageable next() {
        return null;
    }

    /**
     * Returns the previous {@link Pageable} or the first {@link Pageable} if the current one already is the first one.
     *
     * @return
     */
    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    /**
     * Returns the {@link Pageable} requesting the first page.
     *
     * @return
     */
    @Override
    public Pageable first() {
        return null;
    }

    /**
     * Returns whether there's a previous {@link Pageable} we can access from the current one. Will return
     * {@literal false} in case the current {@link Pageable} already refers to the first page.
     *
     * @return
     */
    @Override
    public boolean hasPrevious() {
        return false;
    }
}
