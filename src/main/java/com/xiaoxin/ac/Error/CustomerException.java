package com.xiaoxin.ac.Error;

import lombok.Data;


public class CustomerException extends RuntimeException {
    private Integer code;
    private String message;
    public CustomerException(CustomerError error){
        code = error.getCode();
        message = error.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
