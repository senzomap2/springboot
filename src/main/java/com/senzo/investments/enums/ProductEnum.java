package com.senzo.investments.enums;

public enum ProductEnum {

    RETIREMENT(1),SAVINGS(2);
    private int product;
    ProductEnum(int product) {
        this.product=product;
    }
    public int getProduct(){
        return this.product;
    }
}
