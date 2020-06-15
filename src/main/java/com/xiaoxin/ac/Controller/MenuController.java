package com.xiaoxin.ac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoxin.ac.DTO.UserDTO;
import com.xiaoxin.ac.DTO.UserLog;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Utils.JsonUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MenuController {
    @RequestMapping(value = "/menu",method = RequestMethod.GET)
    public String getMenu(){
        String s = JsonUtils.readJsonFile("menu.json");
        JSONObject jsonObj = JSON.parseObject(s);
        jsonObj.put("code",200);
        System.out.println("done");
        return jsonObj.toString();
    }
}
