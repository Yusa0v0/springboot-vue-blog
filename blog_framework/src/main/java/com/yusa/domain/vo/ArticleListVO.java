package com.yusa.domain.vo;

import java.util.Date;

/**
 * @author Yusa
 * @version 1.0
 */
public class ArticleListVO {
    private Long id;
    private String title;
    private String summary;
    private String categoryName;
    private String thumbnail;
    private Long viewCount;
    private Date createTime;

    public ArticleListVO() {
    }

    public ArticleListVO(Long id, String title, String summary, String categoryName, String thumbnail, Long viewCount, Date createTime) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.categoryName = categoryName;
        this.thumbnail = thumbnail;
        this.viewCount = viewCount;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
