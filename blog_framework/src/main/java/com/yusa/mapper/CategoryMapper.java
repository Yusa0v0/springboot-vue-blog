package com.yusa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yusa.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分类表(Category)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-23 17:05:18
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}

