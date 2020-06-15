package com.xiaoxin.ac.Entity;

import lombok.Data;

@Data
public class Goods {
    private String shopName;
    private String url;
    private int shopID;

    public Goods() {

    }

    public Goods(String shopName, String url) {
        this.shopName = shopName;
        this.url = url;
    }
    public int getShopID(){
        return shopID;
    }
    public void setShopID(int shopID){
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
}
