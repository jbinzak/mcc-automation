package com.mcc.automation.automobile;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class Car {

    // ex: 123
    public int weight;

    // ex: "Mustang"
    private String name;

    public int numberOfDoors;

    public Car(String name){
        this.name = name;
    }


    public int getHalfWeight(){
        return this.weight / 2 ;
    }

    public void setName(String name){
        this.name = name;
    }

    public static boolean needsNewBrakes(int miles){
        return miles > 10;
    }
}
