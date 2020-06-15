package com.xiaoxin.ac.Controller;

import com.xiaoxin.ac.DTO.UserDTO;
import com.xiaoxin.ac.DTO.UserLog;
import com.xiaoxin.ac.DTO.UserSign;
import com.xiaoxin.ac.Entity.User;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public String checkToken(@RequestParam("token") String token){
        User user = userService.findUserByToken(token);
        if (user !=null){
            return Resp.okOf(new UserDTO(user));
        }else{
            return Resp.errorOf(CustomerError.NOT_LOG);
        }
    }

    @RequestMapping(value = "/log",method = RequestMethod.POST)
    public String log(@RequestBody UserLog userLog){
        User user = userService.log(userLog);

        if (user !=null){
            UserDTO userDTO = new UserDTO(user);
            return Resp.okOf(userDTO);
        }else{
            return Resp.errorOf(CustomerError.WRONG_ACCOUNT);
        }
    }

    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    public String sign(@RequestBody UserSign userSign){
        System.out.println(userSign);
        User user = null;
        try{
            user = userService.sign(userSign);
        }catch (CustomerException e){
            return Resp.errorOf(e);
        }
        System.out.println(user);
        if (user !=null){
            UserDTO userDTO = new UserDTO(user);
            return Resp.okOf(userDTO);
        }else{
            return Resp.errorOf(CustomerError.DUPLICATE_ACCOUNT);
        }
    }

    @RequestMapping(value = "/charge",method = RequestMethod.GET)
    public String charge(@RequestParam(name = "userName") String userName,
                         @RequestParam(name = "chargeMoney") double chargeMoney){
        try {
            userService.charge(userName,chargeMoney);
        }catch (CustomerException e){
            return  Resp.errorOf(e);
        }
        return Resp.okOf();
    }


}
