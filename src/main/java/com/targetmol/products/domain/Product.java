package com.targetmol.products.domain;
import lombok.Data;

import javax.persistence.Table;

public class Product  {
    private String code;
    private String casNo;
    private String casName;
    private String brand;
    private Integer quantity;
    private Double price;
    private String pureness;
    private String packSize;
    private String packUnit;
    private String packMode;
    private String isHave;
    private String warehouse;
    private String url;
    private String spec;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCasNo() {
        return casNo;
    }

    public void setCasNo(String casNo) {
        this.casNo = casNo;
    }

    public String getCasName() {
        return casName;
    }

    public void setCasName(String casName) {
        this.casName = casName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPureness() {
        return pureness;
    }

    public void setPureness(String pureness) {
        this.pureness = pureness;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getPackUnit() {
        return packUnit;
    }

    public void setPackUnit(String packUnit) {
        this.packUnit = packUnit;
    }

    public String getPackMode() {
        return packMode;
    }

    public void setPackMode(String packMode) {
        this.packMode = packMode;
    }

    public String getIsHave() {
        return isHave;
    }

    public void setIsHave(String isHave) {
        this.isHave = isHave;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
