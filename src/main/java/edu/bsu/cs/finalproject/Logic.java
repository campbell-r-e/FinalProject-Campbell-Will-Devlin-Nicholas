package edu.bsu.cs.finalproject;

public class Logic {
public void checkZipCode(String json) {
    if(!JSONParser.checkValidZipCode(json)) {
        System.err.println("Invalid Zip code");
    }
}
    public void checkUnit(String User_temp_unit, String json) {
        if (User_temp_unit.equalsIgnoreCase("Fahrenheit")) {
            System.out.println(JSONParser.dataFormatter(json, "Fahrenheit"));
        }

        if (User_temp_unit.equalsIgnoreCase("Celsius")) {
            System.out.println(JSONParser.dataFormatter(json, "Celsius"));
        }
        if (User_temp_unit.equalsIgnoreCase("Fahrenheit And Celsius")) {
            System.out.println(JSONParser.dataFormatter(json, "Fahrenheit And Celsius"));
        }
        if (User_temp_unit.equalsIgnoreCase("forecast")) {
            System.out.println(JSONParser.forecastFormatter(json));
        }

    }
}
