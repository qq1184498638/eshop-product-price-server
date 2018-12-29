package com.springcloud.eshop.product.price.server.controller;

import com.springcloud.eshop.product.price.server.entity.ProductPrice;
import com.springcloud.eshop.product.price.server.service.ProductPriceService;
import com.springcloud.eshop.product.price.server.support.base.XbootBaseController;
import com.springcloud.eshop.product.price.server.support.base.XbootBaseService;
import com.springcloud.eshop.product.price.server.support.utils.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "商品价格相关的接口")
@RequestMapping("/product-price")
public class ProductPriceController extends XbootBaseController<ProductPrice, String> {
    @Autowired
    private ProductPriceService productPriceService;

    @Override
    public XbootBaseService<ProductPrice, String> getService() {
        return productPriceService;
    }

    @ApiOperation("根据商品id查询出商品价格信息")
    @GetMapping("findProductPriceByProductId")
    public ServerResponse findProductPriceByProductId(@RequestParam("productId") String productId) {
        return ServerResponse.createBySuccess(productPriceService.findProductPriceByProductId(productId));
    }
}
