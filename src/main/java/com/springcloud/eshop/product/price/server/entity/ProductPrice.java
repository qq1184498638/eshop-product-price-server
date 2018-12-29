package com.springcloud.eshop.product.price.server.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.springcloud.eshop.product.price.server.support.base.XbootBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_product_price")
@TableName("t_product_price")
public class ProductPrice extends XbootBaseEntity {

    private static final long serialVersionUID = 3731996621722049719L;

    @ApiModelProperty("商品价格")
    @Column(nullable = false)
    private BigDecimal value;

    @ApiModelProperty("商品价格对应的商品id")
    private String productId;
}
