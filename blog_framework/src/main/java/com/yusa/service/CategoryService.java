package com.yusa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yusa.domain.ResponseResult;
import com.yusa.domain.entity.Category;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-10-23 17:05:27
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

