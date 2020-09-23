package com.targetmol.products.domain;
import lombok.Data;

import javax.persistence.Table;

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


    public String getCasno() {
        return casno;
    }

    public void setCasno(String casno) {
        this.casno = casno;
    }

    public String getCasname() {
        return casname;
    }

    public void setCasname(String casname) {
        this.casname = casname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWarehose() {
        return warehose;
    }

    public void setWarehose(String warehose) {
        this.warehose = warehose;
    }

    public String getPureness() {
        return pureness;
    }

    public void setPureness(String pureness) {
        this.pureness = pureness;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getPacksize() {
        return packsize;
    }

    public void setPacksize(Integer packsize) {
        this.packsize = packsize;
    }

    public String getPackunit() {
        return packunit;
    }

    public void setPackunit(String packunit) {
        this.packunit = packunit;
    }

    public String getPackMode() {
        return packMode;
    }

    public void setPackMode(String packMode) {
        this.packMode = packMode;
    }

    public Integer getIsHave() {
        return isHave;
    }

    public void setIsHave(Integer isHave) {
        this.isHave = isHave;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
