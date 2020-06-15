package com.xiaoxin.ac.Entity;

import lombok.Data;

@Data
public class User {
    private String token;
    private String userName;
    private String password;
    private String email;
    private double money;
    private String type;

    public User() {
    }

    public User(String token, String userName, String password, String email, double money, String type) {
        this.token = token;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.money = money;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
