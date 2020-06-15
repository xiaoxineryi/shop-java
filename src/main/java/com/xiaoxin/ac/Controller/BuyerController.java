package com.xiaoxin.ac.Controller;

import com.xiaoxin.ac.DTO.Order;
import com.xiaoxin.ac.DTO.UserLog;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Service.ShopService;
import com.xiaoxin.ac.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class BuyerController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/buyShop",method = RequestMethod.POST)
    public String buyShop(@RequestBody Order order){
        try{
            shopService.buy(order);
        }catch (CustomerException e){
            return Resp.errorOf(e);
        }
        return Resp.okOf(new UserLog());
    }
}
