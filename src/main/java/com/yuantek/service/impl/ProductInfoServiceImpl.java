package com.yuantek.service.impl;

import com.yuantek.dataobject.ProductInfo;
import com.yuantek.repository.ProductInfoRepository;
import com.yuantek.service.IProductInfoService;
import com.yuantek.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iProductInfoService")
public class ProductInfoServiceImpl implements IProductInfoService {
    @Autowired
    private ProductInfoRepository rep;

    public ApiResponse<ProductInfo> findOne(String productId) {
        ProductInfo o = rep.findOne(productId);
        if (o != null) {
            // TODO 这里不能直接返回持久对象,需要返回DTO
            return ApiResponse.createBySuccess(o);
        } else {
            return ApiResponse.createByErrorMessage("此商品不存在");
        }
    }
}