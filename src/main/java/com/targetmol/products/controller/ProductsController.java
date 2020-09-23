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



    @GetMapping("product")
    public ResponseEntity<PageResult> findByCasNo(
            @RequestParam(value = "casNo" ,required = false) String casno,
            @RequestParam(value = "page",required = false) Integer page){
        if(casno==null && page==null){
           PageResult pg= new PageResult();
           pg.setCode(0);
           pg.setCurPage(0);
           pg.setTolPage(0);
           pg.setMessage("失败");
            return ResponseEntity.ok(pg);
        }
        if(casno!=null){
            return ResponseEntity.ok(productsSerivces.findByCasNo(casno,page));
        }
        if(page!=null){
            return ResponseEntity.ok(productsSerivces.findAllCas(page));
        }
        return null;
    }
}
