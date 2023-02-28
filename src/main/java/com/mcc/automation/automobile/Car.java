package com.mcc.automation.automobile;

public class Car {

    // ex: 123
    public int weight;

    // ex: "Mustang"
    private String name;

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
