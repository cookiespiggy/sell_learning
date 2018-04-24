package com.yuantek.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * DTO对象,用于VO的复杂业务封装
 * 此处为商品(包含类目)
 * 属性看前端接口的内部需要什么
 */
@Data
public class ProductCategoryDTO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoDTO> productInfoDTOList;
}
