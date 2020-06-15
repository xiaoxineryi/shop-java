package com.xiaoxin.ac.Service;

import com.xiaoxin.ac.DTO.UserLog;
import com.xiaoxin.ac.DTO.UserSign;
import com.xiaoxin.ac.Entity.User;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByToken(String token){
        return userMapper.findUserByToken(token);
    }

    public User log(UserLog userLog) {
        User user =  userMapper.log(userLog.getUserName(),userLog.getPassword());
        if (user ==null){
            return null;
        }
        user.setToken(UUID.randomUUID().toString());
        int result = userMapper.updateToken(user);
        if(result !=1){
            throw new CustomerException(CustomerError.DUPLICATE_ACCOUNT);
        }else{
            return user;
        }
    }

    public User sign(UserSign userSign) {
        User user = userMapper.findUserByName(userSign.getUserName());
        if (user !=null){
            return null;
        }else{
            String token = UUID.randomUUID().toString();
            User u = new User(token,userSign.getUserName(),userSign.getPassword(),userSign.getEmail(),0,userSign.getType());
            int result = userMapper.sign(u);
            if (result !=1){
                throw new CustomerException(CustomerError.DUPLICATE_ACCOUNT);
            }else{
                return u;
            }
        }
    }

    public void charge(String userName, double chargeMoney) {
        if (userMapper.charge(userName,chargeMoney) !=1){
            throw new CustomerException(CustomerError.FAILED_CHARGE);
        }
    }

}
