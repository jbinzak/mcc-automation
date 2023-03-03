package com.mcc.automation;


import com.mcc.automation.automobile.Car;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class Garage {


    public void test(){

        boolean needsBrakes = Car.needsNewBrakes(60);

        Car myCarB = new Car("My Car");

        String myName = "My Name is John";

    }

}
