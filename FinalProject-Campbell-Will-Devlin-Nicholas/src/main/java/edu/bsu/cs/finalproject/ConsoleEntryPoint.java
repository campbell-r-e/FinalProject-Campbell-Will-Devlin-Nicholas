package edu.bsu.cs.finalproject;

import java.util.Scanner;


public class ConsoleEntryPoint
{
    public static void main(String[] args)
    {
        Scanner command_line_user_interface_tool = new Scanner(System.in);
        Logic controller = new Logic();
        System.out.println("Enter your zip code");
        String zip_code =  command_line_user_interface_tool.nextLine();
        System.out.println("Enter \"c\" for Celsius or \"f\" for Fahrenheit: or Enter \"fc\" to print Fahrenheit and Celsius.\n Enter \"for\" to get the forecast for three days.");
        String User_input = command_line_user_interface_tool.next();
        User_input = UserInputTranslator.convert_keyword_to_word(User_input);
        String current_weather_json = Connection.weatherConnect(zip_code);
        if(User_input.equals("forecast")){
            String three_day_weather_json = Connection.forecastConnect(zip_code);
            controller.checkZipCode(three_day_weather_json);
            controller.checkUnit(User_input,three_day_weather_json);
        }
        else {
            controller.checkZipCode(current_weather_json);
            controller.checkUnit(User_input, current_weather_json);
        }
    }
}