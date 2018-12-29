package com.springcloud.eshop.product.price.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class ProductPriceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceServerApplication.class, args);
	}

}

