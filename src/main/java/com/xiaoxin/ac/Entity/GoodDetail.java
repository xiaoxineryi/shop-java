package com.xiaoxin.ac.Entity;

import java.util.List;

public class GoodDetail {
    private List<GoodDescribe> goodDescribeList;
    private int shopID;
    private String shopName;
    private String sellerName;
    private double price;
    private int left;

    public List<GoodDescribe> getGoodDescribeList() {
        return goodDescribeList;
    }

    public void setGoodDescribeList(List<GoodDescribe> goodDescribeList) {
        this.goodDescribeList = goodDescribeList;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}
