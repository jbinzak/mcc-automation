package com.mcc.automation.auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class User {

    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
