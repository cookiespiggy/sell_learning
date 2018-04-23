package com.yuantek.repository;


import com.yuantek.dataobject.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ProductCategoryRepositoryTest extends ApplicationTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void testSave() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }
}