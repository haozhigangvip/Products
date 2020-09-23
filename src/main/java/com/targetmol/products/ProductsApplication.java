package com.targetmol.products;

import org.springframework.boot.SpringApplication;
import tk.mybatis.spring.annotation.MapperScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan(basePackages= {"com.targetmol.products.dao"})
public class ProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class,args);
    }
}
