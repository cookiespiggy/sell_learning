package com.yuantek.service.impl;

import com.yuantek.dataobject.ProductInfo;
import com.yuantek.repository.ApplicationTest;
import com.yuantek.vo.ApiResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductInfoServiceImplTest extends ApplicationTest {
    @Autowired
    private ProductInfoServiceImpl service; //这种起名没有意义,越短越好

    @Test
    public void findOne() {
        ApiResponse<ProductInfo> res = service.findOne("1");
        //System.out.println(o.getProductName());// 会抛异常,所以service层的东西不能直接返回
        if (res.getCode() == 0) {
            System.out.println(res.getData().getProductName());
        }
    }
}