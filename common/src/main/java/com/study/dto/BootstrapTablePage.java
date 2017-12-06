package com.study.dto;

/**
 * @创建人 chengyin
 * @创建时间 2017/12/6
 * @描述
 */
public class BootstrapTablePage {

    /**
     * 页码
     */
    private Integer offset;

    /**
     * 分页大小
     */
    private Integer limit;

    /**
     * 排序方式
     */
    private String order;

    /**
     * 排序字段
     */
    private String sort;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "BootstrapTablePage{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", order='" + order + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
