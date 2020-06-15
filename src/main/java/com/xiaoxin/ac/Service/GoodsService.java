package com.xiaoxin.ac.Service;

import com.xiaoxin.ac.DTO.GoodsListDTO;
import com.xiaoxin.ac.Entity.GoodDescribe;
import com.xiaoxin.ac.Entity.GoodDetail;
import com.xiaoxin.ac.Entity.Goods;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public GoodsListDTO getIndexGoods(int page){
        List<Goods> goods = goodsMapper.getIndexGoods((page-1)*4);
        int count = goodsMapper.getIndexCount();
        GoodsListDTO goodsListDTO = new GoodsListDTO();
        goodsListDTO.setGoods(goods);
        goodsListDTO.setCount(count);
        return goodsListDTO;
    }

    public GoodsListDTO getGoodsByType(String category,int page) {
        List<Goods> goods = goodsMapper.getGoodsByType(category,(page-1)*4);
        int count = goodsMapper.getGoodsCountByType(category);
        GoodsListDTO goodsListDTO = new GoodsListDTO();
        goodsListDTO.setGoods(goods);
        goodsListDTO.setCount(count);
        return goodsListDTO;
    }

    public GoodDetail getGoodDetailByID(int shopID) {
        List<GoodDescribe> goodDescribes = goodsMapper.getGoodDescribeByshopID(shopID);
        GoodDetail goodDetail = goodsMapper.getGoodsDetailByshopID(shopID);
        try{
            goodDetail.setGoodDescribeList(goodDescribes);
        }catch (Exception e){
            throw new CustomerException(CustomerError.SHOP_NOT_EXIST);
        }
        return goodDetail;
    }

}
