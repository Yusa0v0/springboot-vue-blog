package com.yusa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yusa.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yusa
 * @version 1.0
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
