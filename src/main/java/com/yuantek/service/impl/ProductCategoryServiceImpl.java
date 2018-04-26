package com.yuantek.service.impl;

import com.yuantek.dataobject.ProductCategory;
import com.yuantek.repository.ProductCategoryRepository;
import com.yuantek.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iProductCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService {
    @Autowired
    private ProductCategoryRepository rep;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return rep.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return rep.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return rep.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return rep.save(productCategory);
    }
}
