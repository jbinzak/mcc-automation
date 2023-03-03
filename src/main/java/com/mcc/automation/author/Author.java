package com.mcc.automation.author;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class Author {

    private String name;

    public Author(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
