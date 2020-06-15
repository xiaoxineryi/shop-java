package com.xiaoxin.ac.Resp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Error.ICustomerError;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


@Data
public class Resp {

    public static String okOf(Object object){
        JSONObject jsonObj = new JSONObject();
            jsonObj.put("code",200);
            jsonObj.put("obj",object);

        return jsonObj.toString();
    }
    public static String okOf(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("code",200);

        return jsonObj.toString();
    }
//    public static String okListOf(ArrayList<Object> objList){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",200);
//        jsonObject.put("list",objList);
//        System.out.println(jsonObject);
//        return jsonObject.toString();
//    }

    public static String errorOf(ICustomerError error){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", error.getCode());
        jsonObject.put("message",error.getMessage());

        return jsonObject.toString();
    }

    public static String errorOf(CustomerException error){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", error.getCode());
        jsonObject.put("message",error.getMessage());

        return jsonObject.toString();
    }


}
