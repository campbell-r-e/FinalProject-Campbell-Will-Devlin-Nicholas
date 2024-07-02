package edu.bsu.cs.finalproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JSONParser {
    static LocalDateTime user_ldt;
    public static String dataFormatter(String jsonData, String tempUnit) {
        String city = getCity(jsonData);
        String region = getRegion(jsonData);
        String country = getCountry(jsonData);
        double tempF = getTempF(jsonData);
        double tempC = getTempC(jsonData);
        String conditions = getConditions(jsonData);
        String temperature = "";

        if (tempUnit == null) {
            temperature = String.valueOf(tempF);
            tempUnit = "Fahrenheit";
        }
        if (Objects.equals(tempUnit, "Celsius")) {
            temperature = String.valueOf(tempC);
        }
        if (Objects.equals(tempUnit, "Fahrenheit")) {
            temperature = String.valueOf(tempF);
        }
        if (Objects.equals(tempUnit, "Fahrenheit And Celsius")) {
            temperature = "\n Fahrenheit " + tempF + "\n Celsius: " + tempC;
        }

        double latitude = getLatitude(jsonData);
        double longitude = JSONParser.getLongitude(jsonData);
        String localTime = JSONParser.getLocalTime(jsonData);
        String timeZone = JSONParser.getTimeZone(jsonData);
        user_ldt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);// from https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java
        return "City: " + city + "\nRegion: " + region + "\nCountry: " + country
                + "\nTemperature: " + temperature + "°" + "\nConditions: " + conditions + "\nTemperature Unit: " + tempUnit + "\n"
                + "Latitude: " + latitude + "\n" + "Longitude: " + longitude + "\n" + "Local Time Zone in city: " + timeZone + "\n" + "Local Time in city: " + localTime + "\n" + "Your time:" + user_ldt;
    }

    public static String forecastFormatter(String jsonData) {
        StringBuilder formattedForecast = new StringBuilder();
        List<String> dates = getForecastDates(jsonData);
        for (int day = 0; day < dates.size(); day++) {
            List<Double> maxTemperatureC = getForecastMaxTemperatureC(jsonData);
            List<Double> minTemperatureC = getForecastMinTemperatureC(jsonData);
            List<Double> maxTemperatureF = getForecastMaxTemperatureF(jsonData);
            List<Double> minTemperatureF = getForecastMinTemperatureF(jsonData);
            List<Double> totalPrecipitation = getForecastTotalPrecipitationIn(jsonData);
            List<Double> totalPrecipitationMm = getForecastTotalPrecipitationMm(jsonData);
            List<Double> visibility = getForecastAverageVisibilityKm(jsonData);
            List<Double> visibilityMiles = getForecastAverageVisibilityMiles(jsonData);
            formattedForecast.append("Date: ").append(dates.get(day)).append("\n")
                    .append("Max Temperature (C): ").append(maxTemperatureC.get(day)).append("\n")
                    .append("Min Temperature (C): ").append(minTemperatureC.get(day)).append("\n")
                    .append("Max Temperature (F): ").append(maxTemperatureF.get(day)).append("\n")
                    .append("Min Temperature (F): ").append(minTemperatureF.get(day)).append("\n")
                    .append("Total Precipitation (in): ").append(totalPrecipitation.get(day)).append("\n")
                    .append("Total Precipitation (mm): ").append(totalPrecipitationMm.get(day)).append("\n")
                    .append("Visibility (km): ").append(visibility.get(day)).append("\n")
                    .append("Visibility (miles): ").append(visibilityMiles.get(day)).append("\n\n");
        }
        return formattedForecast.toString();
    }

    public static List<String> getForecastDates(String jsonData) {
        List<String> dates = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            for (int day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                dates.add(forecastday.getString("date"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return dates;
    }
    public static double getTempF(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("current").getDouble("temp_f");
    }

    public static double getTempC(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("current").getDouble("temp_c");
    }

    public static String getConditions(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
    }

    public static String getCity(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getString("name");
    }

    public static String getRegion(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getString("region");
    }

    public static String getCountry(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getString("country");
    }

    public static String getTimeZone(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getString("tz_id");
    }

    public static String getLocalTime(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getString("localtime");
    }
    public static double getLatitude(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getDouble("lat");
    }

    public static Double getLongitude(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getJSONObject("location").getDouble("lon");
    }
    //Forecast Methods Below
    public static List<Double> getForecastMaxTemperatureC(String jsonData) {
        List<Double> maxTemperatures = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            for (int day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                maxTemperatures.add(dayObject.getDouble("maxtemp_c"));

            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return maxTemperatures;
    }


    public static List <Double> getForecastMaxTemperatureF(String jsonData) {
        List<Double> maxTemperatures = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                maxTemperatures.add(dayObject.getDouble("maxtemp_f"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return maxTemperatures;
    }


    public static List <Double> getForecastMinTemperatureC(String jsonData) {
        List<Double> minTemperatures = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                minTemperatures.add(dayObject.getDouble("mintemp_c"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return minTemperatures;
    }

    public static List<Double> getForecastMinTemperatureF(String jsonData) {
        List<Double> minTemperaturesF = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                minTemperaturesF.add(dayObject.getDouble("mintemp_f"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return minTemperaturesF;
    }


    public static List<Double> getForecastTotalPrecipitationMm(String jsonData) {
        List<Double> totalPrecipitationMM = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                totalPrecipitationMM.add(dayObject.getDouble("totalprecip_mm"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return totalPrecipitationMM;
    }


    public static List<Double> getForecastTotalPrecipitationIn(String jsonData) {
        List<Double> totalPrecipitationIN = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                totalPrecipitationIN.add(dayObject.getDouble("totalprecip_in"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return totalPrecipitationIN;
    }

    public static List<Double> getForecastAverageVisibilityKm(String jsonData) {
        List<Double> avgVisibilityKM = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                avgVisibilityKM.add(dayObject.getDouble("avgvis_km"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return avgVisibilityKM;
    }

    public static List<Double> getForecastAverageVisibilityMiles(String jsonData) {
        List<Double> avgVisibilityMiles = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray forecastdayArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday");
            int day;
            for (day = 0; day < forecastdayArray.length(); day++) {
                JSONObject forecastday = forecastdayArray.getJSONObject(day);
                JSONObject dayObject = forecastday.getJSONObject("day");
                avgVisibilityMiles.add(dayObject.getDouble("avgvis_miles"));
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }

        return avgVisibilityMiles;
    }



    public static boolean checkValidZipCode(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return jsonObject.getJSONObject("error").getInt("code") != 1006;
        }
        catch(JSONException jsonException)
        {
            return true;
        }
    }

}