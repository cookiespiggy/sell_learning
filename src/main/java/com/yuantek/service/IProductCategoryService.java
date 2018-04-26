package com.yuantek.service;

import com.yuantek.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品类目服务接口
 */
public interface IProductCategoryService {
    // backend
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    // 买家端
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
