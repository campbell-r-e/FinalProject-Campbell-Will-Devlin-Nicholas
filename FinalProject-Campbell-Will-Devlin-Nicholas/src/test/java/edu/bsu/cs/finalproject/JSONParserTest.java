package edu.bsu.cs.finalproject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import static edu.bsu.cs.finalproject.JSONParser.dataFormatter;

public class JSONParserTest {
    @Test
    public void getTempInFTest()
    {
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals(61.9,JSONParser.getTempF(json));
    }
    @Test
    public void getTempInCTest()
    {
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals(16.6,JSONParser.getTempC(json));
    }
    @Test
    public void getConditionsTest()
    {
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals("Sunny",JSONParser.getConditions(json));
    }
    @Test
    public void getCityTest()
    {
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals("Carmel", JSONParser.getCity(json));
    }
    @Test
    public void getRegionTest()
    {
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals("Indiana",JSONParser.getRegion(json));
    }
    @Test
    public void getCountryTest()
    {
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals("USA",JSONParser.getCountry(json));
    }
    @Test
    public void invalidZipCodeTest()
    {
        String invalid_zip_code = readSampleFileAsString("invalid_zip_code.json");
        String test = readSampleFileAsString("test.json");
        Assertions.assertTrue(JSONParser.checkValidZipCode(test));
        Assertions.assertFalse(JSONParser.checkValidZipCode(invalid_zip_code));
    }

    private String readSampleFileAsString(String filename)
    {
        try
        {
            InputStream sampleFile = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
        catch(Exception exception)
        {
            System.err.println("Invalid File");
            System.exit(0);
            return null;
        }

    }
    @Test
    public void Test_Latitude(){
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals(39.98,JSONParser.getLatitude(json));

    }
    @Test
    public void Test_Longitude(){
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals(-86.08,JSONParser.getLongitude(json));
    }
    @Test
    public void Test_Timezone(){
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals("America/Indiana/Indianapolis",JSONParser.getTimeZone(json));
    }
    @Test
    public void test_local_time(){
        String json = readSampleFileAsString("test.json");
        Assertions.assertEquals("2023-10-18 14:29",JSONParser.getLocalTime(json));
    }
    @Test
    public void testMaxTempC() {
        String json = readSampleFileAsString("forecastTest.json");
        List<Double> result = JSONParser.getForecastMaxTemperatureC(json);
        double[] expected = {3.4, 4.4, 3.5};
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], result.get(i), 0.01);
        }
    }
    @Test
    public void testMaxTempF(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>results=JSONParser.getForecastMaxTemperatureF(json);
        double[]expectedResults={38.2,39.9,38.3};
        for (int i=0;i<expectedResults.length;i++){
            Assertions.assertEquals(expectedResults[i],results.get(i),0.01);
        }
    }
    @Test
    public void testMinTempC(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>result=JSONParser.getForecastMinTemperatureC(json);
        double[]expected={0.9,0.2,0.1};
        for(int i=0;i< expected.length;i++){
            Assertions.assertEquals(expected[i],result.get(i),0.01);
        }
    }
    @Test
    public void testMinTempF(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>result=JSONParser.getForecastMinTemperatureF(json);
        double[]expected={33.7,32.4,32.1};
        for(int i=0;i< expected.length;i++){
            Assertions.assertEquals(expected[i],result.get(i),0.01);
        }
    }
    @Test
    public void testTotalPrecipitationMM(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>result=JSONParser.getForecastTotalPrecipitationMm(json);
        double[]expected={1.49,0.34,0.01};
        for(int i=0;i< expected.length;i++){
            Assertions.assertEquals(expected[i],result.get(i),0.01);
        }
    }
    @Test
    public void testTotalPrecipitationIN(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>result=JSONParser.getForecastTotalPrecipitationIn(json);
        double[]expected={0.06,0.01,0.0};
        for(int i=0;i< expected.length;i++){
            Assertions.assertEquals(expected[i],result.get(i),0.01);
        }
    }
    @Test
    public void testAVGVisibilityKM(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>result=JSONParser.getForecastAverageVisibilityKm(json);
        double[]expected={9.8,10.0,10.0};
        for(int i=0;i< expected.length;i++){
            Assertions.assertEquals(expected[i],result.get(i),0.01);
        }
    }

    @Test
    public void testAVGVisibilityMiles(){
        String json=readSampleFileAsString("forecastTest.json");
        List<Double>result=JSONParser.getForecastAverageVisibilityMiles(json);
        double[]expected={6.0,6.0,6.0};
        for(int i=0;i< expected.length;i++){
            Assertions.assertEquals(expected[i],result.get(i),0.01);
        }
    }
    @Test
    public void DataFormatterTest_null(){


       Assertions.assertEquals("City: " + "Carmel" + "\nRegion: " + "Indiana" + "\nCountry: " + "USA"
               + "\nTemperature: " + "61.9" + "°" + "\nConditions: " + "Sunny"+ "\nTemperature Unit: "+ "Fahrenheit" +"\n"
               + "Latitude: " +"39.98" +"\n" +"Longitude: " + "-86.08" +"\n" + "Local Time Zone in city: "+ "America/Indiana/Indianapolis" +"\n"+"Local Time in city: "+ "2023-10-18 14:29" + "\n"+"Your time:"+LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),dataFormatter(readSampleFileAsString("test.json"),null));
    }
    @Test
    public void DataFormatterTest_Fahrenheit(){
        Assertions.assertEquals("City: " + "Carmel" + "\nRegion: " + "Indiana" + "\nCountry: " + "USA"
                + "\nTemperature: " + "61.9" + "°" + "\nConditions: " + "Sunny"+ "\nTemperature Unit: "+ "Fahrenheit" +"\n"
                + "Latitude: " +"39.98" +"\n" +"Longitude: " + "-86.08" +"\n" + "Local Time Zone in city: "+ "America/Indiana/Indianapolis" +"\n"+"Local Time in city: "+ "2023-10-18 14:29" + "\n"+"Your time:"+LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),dataFormatter(readSampleFileAsString("test.json"),"Fahrenheit"));
    }
    @Test
    public void DataFormatterTest_Fahrenheit_Celsius(){
        Assertions.assertEquals("City: " + "Carmel" + "\nRegion: " + "Indiana" + "\nCountry: " + "USA"
                +  "\nTemperature: " + "\n Fahrenheit "+"61.9" +"\n Celsius:"+ " 16.6"+"°"+ "\nConditions: " + "Sunny"+ "\nTemperature Unit: "+ "Fahrenheit And Celsius" +"\n"
                + "Latitude: " +"39.98" +"\n" +"Longitude: " + "-86.08" +"\n" + "Local Time Zone in city: "+ "America/Indiana/Indianapolis" +"\n"+"Local Time in city: "+ "2023-10-18 14:29" + "\n"+"Your time:"+LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),dataFormatter(readSampleFileAsString("test.json"),"Fahrenheit And Celsius"));
    }
    @Test
    public void DataFormatterTest_Celsius(){
        Assertions.assertEquals("City: " + "Carmel" + "\nRegion: " + "Indiana" + "\nCountry: " + "USA"
                + "\nTemperature: "  + "16.6"+ "°" + "\nConditions: " + "Sunny"+ "\nTemperature Unit: "+ "Celsius" +"\n"
                + "Latitude: " +"39.98" +"\n" +"Longitude: " + "-86.08" +"\n" + "Local Time Zone in city: "+ "America/Indiana/Indianapolis" +"\n"+"Local Time in city: "+ "2023-10-18 14:29" + "\n"+"Your time:"+LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),dataFormatter(readSampleFileAsString("test.json"),"Celsius"));
    }

}
