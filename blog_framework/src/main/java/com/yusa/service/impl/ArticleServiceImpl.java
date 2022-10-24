package com.yusa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yusa.constants.SystemConstants;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Article;
import com.yusa.domain.entity.Category;
import com.yusa.domain.vo.ArticleDetailVO;
import com.yusa.domain.vo.ArticleListVO;
import com.yusa.domain.vo.HotArticleVo;
import com.yusa.domain.vo.PageVO;
import com.yusa.mapper.ArticleMapper;
import com.yusa.service.ArticleService;
import com.yusa.service.CategoryService;
import com.yusa.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.yusa.constants.SystemConstants.ARTICLE_STATUS_NORMAL;

/**
 * @author Yusa
 * @version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    CategoryService categoryService;
    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章，封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查10条
        Page<Article> page = new Page(1, 10);
        page(page, queryWrapper);
        List<Article> articleList = page.getRecords();
//        List<HotArticleVo> hotArticleVoList = new ArrayList<>();
//        for (Article article:articleList) {
//            HotArticleVo vo = new HotArticleVo();
//            BeanUtils.copyProperties(article,vo);
//            hotArticleVoList.add(vo);
//        }
        List<HotArticleVo> vs = BeanCopyUtils.copyBeanList(articleList, HotArticleVo.class);
        return ResponseResult.okResult(vs);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        // 查询调节
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 如果有categoryId，则查询时要和传入的相同
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        // 只能是正式发布的文章
        lambdaQueryWrapper.eq(Article::getStatus, ARTICLE_STATUS_NORMAL);
        // 对isTop进行降序排序
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page,lambdaQueryWrapper);
        // 查询分类名称
        List<Article> articleList= page.getRecords();
        for (Article article : articleList) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }
        // 封装查询结果
        List<ArticleListVO> articleListVOS = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVO.class);
        PageVO pageVO =new PageVO(articleListVOS,page.getTotal());



        return ResponseResult.okResult(pageVO);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        // 根据文章id查询
        Article article = getById(id);
        // 封装成VO
        ArticleDetailVO articleDetailVO = BeanCopyUtils.copyBean(article, ArticleDetailVO.class);
        // 根据分类id查询分类名
        Long categoryId = article.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if(category!=null){
            articleDetailVO.setCategoryName(category.getName());
        }

        // 封装响应
        return ResponseResult.okResult(articleDetailVO);
    }


}
