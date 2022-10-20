package com.yusa.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yusa.domain.entity.Article;
import com.yusa.domain.mapper.ArticleMapper;
import com.yusa.domain.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author Yusa
 * @version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService   {

}
