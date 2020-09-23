package com.targetmol.products.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.targetmol.products.dao.ProductsDao;
import com.targetmol.products.domain.Product;
import com.targetmol.products.domain.vo.PageResult;
import com.targetmol.products.domain.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsSerivces {
    @Autowired
    private ProductsDao productsDao;





    public PageResult findByCasNo(String casno, Integer page) {
        try{
            Integer pageSize;
            if(page==null){
                page=1;
                pageSize=99999999;
            }else{
                pageSize=100;
            }
            Page pg=PageHelper.startPage(page,pageSize);
            List<Product> lst=new ArrayList<Product>();
            PageInfo<Product> info=new PageInfo<Product>(pg);
            return new PageResult<Product>((int)info.getPages(),info.getPageNum(),lst);
        }catch (Exception e){
            return new PageResult<String>(0,"失败",0,0,null);

        }
    }

    public PageResult findAllCas(Integer page) {
        try{
            Integer pageSize;
            if(page==null){
                page=1;
                pageSize=99999999;
            }else{
                pageSize=100;
            }
            Page pg=PageHelper.startPage(page,pageSize);
            List<String> lst=productsDao.findAllCas();
            PageInfo<String> info=new PageInfo<String>(pg);
            return new PageResult<String>((int)info.getPages(),info.getPageNum(),lst);

        }catch (Exception e){
            return new PageResult<String>(0,"失败",0,0,null);
        }

    }
}
