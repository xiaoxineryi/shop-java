package com.xiaoxin.ac.Entity;

public class sellShop {
    int shopID;
    String shopName;
    String url;
    int left;
    double price;

    public sellShop(int shopID, String shopName, String url, int left, double price) {
        this.shopID = shopID;
        this.shopName = shopName;
        this.url = url;
        this.left = left;
        this.price = price;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
