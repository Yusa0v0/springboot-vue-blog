package com.yusa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Article;
import com.yusa.mapper.ArticleMapper;
import com.yusa.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yusa
 * @version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章，封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus,0);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查10条
        Page<Article> page = new Page(1,10);
        page(page,queryWrapper);
        List<Article> articleList= page.getRecords();
        return ResponseResult.okResult(articleList);
    }
}
