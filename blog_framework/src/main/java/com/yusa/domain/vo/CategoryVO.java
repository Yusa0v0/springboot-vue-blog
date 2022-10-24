package com.yusa.domain.vo;

/**
 * @author Yusa
 * @version 1.0
 */
public class CategoryVO {
    private Long id;
    private String name;

    public CategoryVO() {
    }

    public CategoryVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
