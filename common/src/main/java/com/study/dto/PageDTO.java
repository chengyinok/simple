package com.study.dto;

/**
 * Description:
 * User: chengyin
 * Date: 2017-12-02
 * Time: 15:42
 */
public class PageDTO {

    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
