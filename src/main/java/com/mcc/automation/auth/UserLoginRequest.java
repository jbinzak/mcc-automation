package com.mcc.automation.auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class UserLoginRequest {

    private String email;
    private String password;


    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }


    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
