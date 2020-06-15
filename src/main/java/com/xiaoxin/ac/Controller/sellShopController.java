package com.xiaoxin.ac.Controller;

import com.xiaoxin.ac.Entity.AddInfo;
import com.xiaoxin.ac.Entity.sellShop;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin("*")
@RestController
public class sellShopController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/sellShop",method = RequestMethod.GET)
    public String getSellShop(@RequestParam(name = "sellerName") String sellerName){
        List<sellShop> sellShopList = shopService.getsellShopBySellerName(sellerName);
        return Resp.okOf(sellShopList);
    }

    @RequestMapping(value = "/shopEditInfo",method = RequestMethod.GET)
    public String getshopInfo(@RequestParam(name = "shopID") int shopID){
        sellShop sellShopList = shopService.getsellShopByID(shopID);
        return Resp.okOf(sellShopList);
    }
    @RequestMapping(value = "/updateShopInfo",method = RequestMethod.POST)
    public String updateShopInfo(@RequestBody sellShop sellShop){
        try{
            shopService.updateSellShop(sellShop);
        }catch (CustomerException e){
            return Resp.errorOf(e);
        }
        return Resp.okOf(sellShop);
    }

    @RequestMapping(value = "/addShop",method = RequestMethod.POST)
    public String addShop(@RequestParam("files") List<MultipartFile> files,
                          @RequestParam("shopName") String shopName,
                          @RequestParam("sellerName")String sellerName,
                          @RequestParam("price") double price,
                          @RequestParam("left") int left,
                          @RequestParam("type") String type) throws IOException {

        sellShop shop = null;
        try{
            shop = shopService.addShop(shopName,sellerName,price,left,type,files);
        }catch (CustomerException e){
            return Resp.errorOf(e);
        }


        return  Resp.okOf(shop);
    }

}
