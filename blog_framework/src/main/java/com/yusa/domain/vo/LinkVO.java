package com.yusa.domain.vo;

import java.util.Date;

/**
 * @author Yusa
 * @version 1.0
 */
public class LinkVO {
    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;

    public LinkVO() {
    }

    public LinkVO(Long id, String name, String logo, String description, String address) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.address = address;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
