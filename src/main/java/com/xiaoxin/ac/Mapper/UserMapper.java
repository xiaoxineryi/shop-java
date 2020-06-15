package com.xiaoxin.ac.Mapper;

import com.xiaoxin.ac.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    @Select("select * from user where token = #{token}")
    User findUserByToken(@Param("token") String token);

    @Select("select * from user where userName=#{userName} and password = #{password}")
    User log(@Param("userName") String userName, @Param("password") String password);

    @Update("update user set token = #{token} where userName = #{userName}")
    int updateToken(User user);

    @Select("select * from user where userName = #{userName}")
    User findUserByName(String userName);
    @Insert("insert into user (token,userName,password,email,type,money) values (#{token},#{userName},#{password},#{email},#{type},#{money})")
    int sign(User u);

    @Update("update user set user.money = user.money + #{money} where user.userName = #{receiver}")
    void addMoney(String receiver, double money);
    @Update("update user set user.money = user.money - #{money} where user.userName = #{poster}")
    void subMoney(String poster, double money);

    @Update("update user set user.money = user.money + #{chargeMoney} where user.userName = #{userName}")
    int charge(String userName, double chargeMoney);
}
