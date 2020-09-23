package com.targetmol.products.controller;

import com.targetmol.products.domain.Product;
import com.targetmol.products.domain.vo.PageResult;
import com.targetmol.products.domain.vo.ResultMsg;
import com.targetmol.products.service.ProductsSerivces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping()
@RestController
public class ProductsController {
    @Autowired
    private ProductsSerivces productsSerivces;

    @GetMapping("cas")
    public ResponseEntity<PageResult> findAllCas(@RequestParam(value = "page",required = false) Integer page){
        return ResponseEntity.ok(productsSerivces.findAllCas(page));
    }


    @GetMapping("product")
    public ResponseEntity<ResultMsg> findByCas(@RequestParam("casNo") String casno){
        return ResponseEntity.ok(productsSerivces.findByCas(casno));
    }
}
