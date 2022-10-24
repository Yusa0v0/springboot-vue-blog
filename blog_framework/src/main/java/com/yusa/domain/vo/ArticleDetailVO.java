package com.yusa.domain.vo;

import java.util.Date;

/**
 * @author Yusa
 * @version 1.0
 */
public class ArticleDetailVO {
    private Long id;
    private String title;
    private String summary;
    private Long categoryId;
    private String categoryName;
    private String thumbnail;
    private String content;
    private Long viewCount;
    private Date createTime;

    public ArticleDetailVO() {
    }

    public ArticleDetailVO(Long id, String title, String summary, Long categoryId, String categoryName, String thumbnail, String content, Long viewCount, Date createTime) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.thumbnail = thumbnail;
        this.content = content;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
