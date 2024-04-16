package edu.bsu.cs.finalproject;

public class UserInputTranslator {
    public static String convert_keyword_to_word(String User_temp_unit){
        if(User_temp_unit == null){
            User_temp_unit = "Fahrenheit";

        }
        else if(User_temp_unit.equalsIgnoreCase("F")){
            User_temp_unit = "Fahrenheit";

        }
        else if (User_temp_unit.equalsIgnoreCase("c")) {

            User_temp_unit = "Celsius";


        }else if(User_temp_unit.equalsIgnoreCase("fc")){
            User_temp_unit = "Fahrenheit And Celsius";
        }
        else if(User_temp_unit.equalsIgnoreCase("for")){
            User_temp_unit = "forecast";
        }else{
            System.out.println("invaild Command");

            System.exit(0);
        }
        return User_temp_unit;
    }
}
