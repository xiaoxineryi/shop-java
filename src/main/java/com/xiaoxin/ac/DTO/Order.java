package com.xiaoxin.ac.DTO;

public class Order {
    private String buyerName;
    private int shopID;
    private int num;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyerName='" + buyerName + '\'' +
                ", shopID=" + shopID +
                ", num=" + num +
                '}';
    }
}
