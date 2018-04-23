package com.yuantek.repository;

import com.yuantek.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository
        extends JpaRepository<ProductInfo, String> {
    
}
