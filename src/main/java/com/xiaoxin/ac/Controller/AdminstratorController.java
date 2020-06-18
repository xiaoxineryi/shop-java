package com.xiaoxin.ac.Controller;

import com.xiaoxin.ac.Entity.sellShop;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminstratorController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/getAllShops" ,method = RequestMethod.GET)
    public String getAllShops(){
        List<sellShop> sellShopList = shopService.getAllShops();
        return Resp.okOf(sellShopList);
    }

    @RequestMapping(value = "/deleteShop",method = RequestMethod.GET)
    public String deleteShop(@RequestParam("shopID") int shopID){
        try{
            shopService.deleteShop(shopID);
        }catch (CustomerException e){
            return Resp.errorOf(e);
        }
        return Resp.okOf();
    }
}
