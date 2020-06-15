package com.xiaoxin.ac.DTO;

import com.xiaoxin.ac.Entity.User;
import lombok.Data;

@Data
public class UserDTO {
    String userName;
    String token;
    String type ;
    public UserDTO(User user){
        this.userName = user.getUserName();
        this.token = user.getToken();
        this.type = user.getType();
    }
}
