package com.yuantek.service.impl;

import com.yuantek.dataobject.ProductInfo;
import com.yuantek.enums.ProductStatusEnum;
import com.yuantek.repository.ProductInfoRepository;
import com.yuantek.service.IProductInfoService;
import com.yuantek.vo.ApiResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ApiResponse<List<ProductInfo>> findUpAll() {
        List<ProductInfo> list = rep.findByProductStatus(ProductStatusEnum.UP.getCode());
        if (CollectionUtils.isNotEmpty(list)) {
            return ApiResponse.createBySuccess(list);
        } else {
            return ApiResponse.createByError();
        }
    }

    public ApiResponse<Page<ProductInfo>> findAll(Pageable pageable) {
        Page<ProductInfo> page = rep.findAll(pageable);
        if (page.getTotalElements() > 0) {
            return ApiResponse.createBySuccess(page);
        } else {
            return ApiResponse.createByError();
        }
    }

    public ApiResponse<ProductInfo> save(ProductInfo productInfo) {
        ProductInfo o = rep.save(productInfo);
        if (o != null) {
            // TODO 这里不能直接返回持久对象,需要返回DTO
            return ApiResponse.createBySuccess("添加成功", o);
        } else {
            return ApiResponse.createByErrorMessage("保存失败");
        }
    }
}