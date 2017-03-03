package com.fh.entity.vo;

import com.fh.entity.common.Pagination;

import java.io.Serializable;

/**
 * 查询类基类
 * Created by liuxi on 2016/12/31.
 */
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 5238686815814225667L;

    //分页参数
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
