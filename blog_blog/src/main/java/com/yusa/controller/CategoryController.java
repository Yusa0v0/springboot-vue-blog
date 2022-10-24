package com.yusa.controller;

import com.yusa.domain.ResponseResult;
import com.yusa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yusa
 * @version 1.0
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("getCategoryList")
    public ResponseResult getCategoryList (){
        return categoryService.getCategoryList();
    }
}
