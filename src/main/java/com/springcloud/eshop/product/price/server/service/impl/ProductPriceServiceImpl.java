package com.springcloud.eshop.product.price.server.service.impl;

import com.springcloud.eshop.product.price.server.entity.ProductPrice;
import com.springcloud.eshop.product.price.server.repository.ProductPriceRepository;
import com.springcloud.eshop.product.price.server.service.ProductPriceService;
import com.springcloud.eshop.product.price.server.support.base.XbootBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductPriceServiceImpl implements ProductPriceService {
    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public XbootBaseRepository<ProductPrice, String> getRepository() {
        return productPriceRepository;
    }

    @Override
    @Cacheable(value = "eshop:product:price", key = "#entity.productId")
    public ProductPrice save(ProductPrice entity) {
        return productPriceRepository.save(entity);
    }

    @Override
    public ProductPrice update(ProductPrice entity) {
        ProductPrice productPrice = productPriceRepository.saveAndFlush(entity);
        redisTemplate.opsForValue().set("eshop:product:price::" + entity.getProductId(), entity.getProductId());
        return productPrice;
    }

    @Override
    public void delete(String id) {
        ProductPrice productPrice = get(id);
        productPriceRepository.deleteById(id);
        redisTemplate.delete("eshop:product:price::" + productPrice.getProductId());
    }

    @Override
    public ProductPrice findProductPriceByProductId(String productId) {
        return productPriceRepository.findProductPriceByProductId(productId);
    }
}
