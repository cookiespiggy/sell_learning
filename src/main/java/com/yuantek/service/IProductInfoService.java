package com.yuantek.service;

import com.yuantek.dataobject.ProductInfo;
import com.yuantek.vo.ApiResponse;

/**
 * 商品详情服务接口
 */
public interface IProductInfoService {

    // service层的东西不能直接返回,所以也不能返回和持久层一样的对象了,需要包装一下
    ApiResponse<ProductInfo> findOne(String productId);

}
