package com.targetmol.products.domain;
import lombok.Data;

import javax.persistence.Table;

@Data
public class Product  {
    private String casno;
    private String casname;
    private String brand;
    private String code;
    private Double price;
    private Integer quantity;
    private String warehose;
    private String pureness;
    private String spec;
    private Integer packsize;
    private String packunit;
    private String packMode;
    private Integer isHave;
    private String url;
}
