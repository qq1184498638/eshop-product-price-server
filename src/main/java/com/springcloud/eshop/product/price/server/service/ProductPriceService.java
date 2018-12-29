package com.springcloud.eshop.product.price.server.service;

import com.springcloud.eshop.product.price.server.entity.ProductPrice;
import com.springcloud.eshop.product.price.server.support.base.XbootBaseService;

public interface ProductPriceService extends XbootBaseService<ProductPrice, String> {

    ProductPrice findProductPriceByProductId(String productId);
}
