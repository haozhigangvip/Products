package com.targetmol.products.domain.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 通用返回类
 * @param <T>
 */

@Data
public class PageResult<T> {
    private Integer code;
    private String message;
    private Integer tolPage;
    private Integer curPage;
    private List<T> data;





    public PageResult(){
    }


    public PageResult(Integer tolPage,Integer curPage,List<T> data){
        this.code=1;
        this.message="成功";
        this.tolPage=tolPage;
        this.curPage=curPage;
        this.data=data;
    }
    public PageResult(Integer code,String message,Integer tolPage,Integer curPage,List<T> data){
        this.code=code;
        this.message=message;
        this.tolPage=tolPage;
        this.curPage=curPage;
        this.data=data;
    }
}
