package com.yusa.domain.vo;

import java.util.List;

/**
 * @author Yusa
 * @version 1.0
 */
public class PageVO {
    private List rows;
    private Long total;

    public PageVO(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public PageVO() {
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
