package com.yuantek.service;

import com.yuantek.dataobject.ProductInfo;
import com.yuantek.vo.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品详情服务接口
 */
public interface IProductInfoService {

    // service层的东西不能直接返回,所以也不能返回和持久层一样的对象了,需要包装一下
    ApiResponse<ProductInfo> findOne(String productId);

    // 查询所有上架商品
    ApiResponse<List<ProductInfo>> findUpAll();

    ApiResponse<Page<ProductInfo>> findAll(Pageable pageable);

    ApiResponse<ProductInfo> save(ProductInfo productInfo);

    // 加库存

    // 减库存

}
