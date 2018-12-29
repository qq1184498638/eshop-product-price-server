package com.springcloud.eshop.product.price.server.repository;

import com.springcloud.eshop.product.price.server.entity.ProductPrice;
import com.springcloud.eshop.product.price.server.support.base.XbootBaseRepository;

public interface ProductPriceRepository extends XbootBaseRepository<ProductPrice, String> {

    ProductPrice findProductPriceByProductId(String productId);
}
