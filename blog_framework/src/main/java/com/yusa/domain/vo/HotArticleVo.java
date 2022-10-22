package com.yusa.domain.vo;

/**
 * @author Yusa
 * @version 1.0
 */
public class HotArticleVo {
    private Long id;
    private String title;
    private Long viewCount;

    public HotArticleVo() {
    }

    public HotArticleVo(Long id, String title, Long viewCount) {
        this.id = id;
        this.title = title;
        this.viewCount = viewCount;
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

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
}
