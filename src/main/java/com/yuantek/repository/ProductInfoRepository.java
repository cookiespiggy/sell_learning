package com.yuantek.repository;

import com.yuantek.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository
        extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商品状态查询商品列表
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
