package com.xiaoxin.ac.Controller;

import com.xiaoxin.ac.DTO.GoodsListDTO;
import com.xiaoxin.ac.Entity.Goods;
import com.xiaoxin.ac.Entity.GoodDetail;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/goodlist",method = RequestMethod.GET)
    public String getGoodsList(@RequestParam("category") String category,
                               @RequestParam("page") int page){
        GoodsListDTO goodsListDTOS = goodsService.getGoodsByType(category,page);

        return Resp.okOf( goodsListDTOS);
    }

    @RequestMapping(value = "/goodIndex",method = RequestMethod.GET)
    public String getGoodsIndex(@RequestParam("page") int page){
        GoodsListDTO goodsListDTOS = goodsService.getIndexGoods(page);

        return Resp.okOf( goodsListDTOS);
    }

    @RequestMapping(value = "/goodDetail",method = RequestMethod.GET)
    public String getGoodDetail(@RequestParam("shopID") int shopID){
        GoodDetail goodDetail = null;
        try {
            goodDetail = goodsService.getGoodDetailByID(shopID);
        }catch (CustomerException e){
            return Resp.errorOf(e);
        }

        return Resp.okOf(goodDetail);
    }

}
