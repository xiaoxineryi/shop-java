package com.xiaoxin.ac.DTO;

import com.xiaoxin.ac.Entity.Goods;

import java.util.List;

public class GoodsListDTO {
    private List<Goods> goods;
    private int count ;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
