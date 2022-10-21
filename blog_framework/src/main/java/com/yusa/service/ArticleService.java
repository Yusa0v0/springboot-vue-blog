package com.yusa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Article;

/**
 * @author Yusa
 * @version 1.0
 */
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
