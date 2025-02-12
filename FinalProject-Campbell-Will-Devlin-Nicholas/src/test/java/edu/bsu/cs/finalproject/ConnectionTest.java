package edu.bsu.cs.finalproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConnectionTest {
    @Test
    void testWeatherConnect()
    {
        int zip = 58463;
        String testConnect = Connection.weatherConnect(String.valueOf(zip));
        Assertions.assertNotNull(testConnect);
    }
    @Test
    void testForecastConnect(){
        String city="Dayton";
        String testForecast=Connection.forecastConnect(city);
        Assertions.assertNotNull(testForecast);
    }
}
