package com.study.dto;

/**
 * @创建人 chengyin
 * @创建时间 2017/12/7
 * @描述
 */
public class DataTablesPage {

    /**
     * 绘制计数器。这个是用来确保Ajax从服务器返回的是对应的
     */
    private Integer draw;

    /**
     * 第一条数据的起始位置，比如0代表第一条数据
     */
    private Integer start;

    /**
     * 告诉服务器每页显示的条数
     */
    private Integer length;

    /**
     * 排序方式
     */
    private String order;

    /**
     * 排序字段
     */
    private String sort;


    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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
        return "DataTablesPage{" +
                "draw=" + draw +
                ", start=" + start +
                ", length=" + length +
                ", order='" + order + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
