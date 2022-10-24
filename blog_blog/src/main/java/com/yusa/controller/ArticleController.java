package com.yusa.controller;

import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Article;
import com.yusa.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yusa
 * @version 1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/list")
    public List<Article> test(){
        return articleService.list();
    }
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        ResponseResult responseResult = articleService.hotArticleList();
        return responseResult;
    }
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        ResponseResult responseResult = articleService.articleList(pageNum,pageSize,categoryId);
        return responseResult;
    }
}
