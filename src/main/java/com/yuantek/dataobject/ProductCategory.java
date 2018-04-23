package com.yuantek.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    @Length(max = 32)
    private String categoryName;

    private Integer categoryType;

}
