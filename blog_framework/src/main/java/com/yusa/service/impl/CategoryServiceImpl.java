package com.yusa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yusa.constants.SystemConstants;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Article;
import com.yusa.domain.entity.Category;
import com.yusa.domain.vo.CategoryVO;
import com.yusa.mapper.CategoryMapper;
import com.yusa.service.ArticleService;
import com.yusa.service.CategoryService;
import com.yusa.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.yusa.constants.SystemConstants.ARTICLE_STATUS_NORMAL;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-10-23 17:05:27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private ArticleService articleService;
    @Override
    public ResponseResult getCategoryList() {

        // 查询文章表中状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
                articleWrapper.eq(Article::getStatus,ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        // 获取文章的分类id，并且去重
        Set<Long> categroyIds = articleList.stream()
                .map(new Function<Article, Long>() {
                    @Override
                    public Long apply(Article article) {
                        return article.getCategoryId();
                    }
                })
                .collect(Collectors.toSet());
        // 查询分类表
        List<Category> categories = listByIds(categroyIds);
        categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        // 封装成vo
        List<CategoryVO> categoriesvo = BeanCopyUtils.copyBeanList(categories, CategoryVO.class);
        return ResponseResult.okResult(categoriesvo);
    }
}

