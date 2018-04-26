package com.yuantek.controller;

import com.google.common.collect.Lists;
import com.yuantek.dataobject.ProductCategory;
import com.yuantek.dataobject.ProductInfo;
import com.yuantek.service.IProductCategoryService;
import com.yuantek.service.IProductInfoService;
import com.yuantek.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品控制器.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private IProductInfoService iProductInfoService;
    @Autowired
    private IProductCategoryService iProductCategoryService;

    @GetMapping("/list")
    public ApiResponse list() {

        // 1. 查询所有的上架商品
        ApiResponse<List<ProductInfo>> all = iProductInfoService.findUpAll();
        // 2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = Lists.newArrayList();
//        all.getData().forEach( o -> categoryTypeList.add(o.getCategoryType()));
        List<Integer> categoryTypeList = all.getData().stream().map(o -> o.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategories = iProductCategoryService.findByCategoryTypeIn(categoryTypeList);
        // 3. 数据拼装
        return null;
    }
}
