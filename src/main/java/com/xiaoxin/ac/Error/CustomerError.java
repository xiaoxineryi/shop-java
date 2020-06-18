package com.xiaoxin.ac.Error;

public enum CustomerError implements ICustomerError {
    NOT_LOG(401,"用户未登录"),
    WRONG_ACCOUNT(402,"账户或密码错误"),
    DUPLICATE_ACCOUNT (403,"用户名已被注册"),
    NO_SUCH_GOOD(404,"没有该商品"),
    NOT_ENOUGH_MONEY(405,"余额不足"),
    SYSTEM_ERROR(500,"系统错误"),
    FAILED_CHARGE(406,"充值失败") ,
    SAVE_ERROR(408,"图片保存错误"),
    SHOP_NOT_EXIST(409,"商品还未上架"),
    FAILED_DELETE(410,"商品还未上架"),
    DATABASE_ERROR(407,"数据库操作错误");
    private Integer code;
    private String message;
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
    CustomerError(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
