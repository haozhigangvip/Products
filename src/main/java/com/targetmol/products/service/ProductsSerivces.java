package com.targetmol.products.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.targetmol.products.dao.ProductsDao;
import com.targetmol.products.domain.Product;
import com.targetmol.products.domain.vo.PageResult;
import com.targetmol.products.domain.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsSerivces {
    @Autowired
    private ProductsDao productsDao;

    public ResponseEntity<ResultMsg<List<Product>>> findByCasNo(String casno) {
        try{
            List<Product> lst=productsDao.findByCasNo(casno);
            if(lst==null||lst.size()<=0){
                return ResponseEntity.ok(ResultMsg.<List<Product>>error(0,"失败"));
            }
            return  ResponseEntity.ok(ResultMsg.success(lst));
        }catch (Exception e){
            return ResponseEntity.ok(ResultMsg.<List<Product>>error(0,"失败"));
        }
    }

    public ResponseEntity<PageResult<String>> findAllCas(Integer page) {
        try{
            Integer pageSize;
            if(page==null){
                page=1;
                pageSize=99999999;
            }else{
                pageSize=200;
            }
            Page pg=PageHelper.startPage(page,pageSize);
            List<String> lst=productsDao.findAllCas();
            PageInfo<String> info=new PageInfo<String>(pg);
            return ResponseEntity.ok(new PageResult<String>((int)info.getPages(),info.getPageNum(),lst));

        }catch (Exception e){
            return  ResponseEntity.ok(new PageResult<String>(0,"失败",0,0,null));
        }

    }



}
