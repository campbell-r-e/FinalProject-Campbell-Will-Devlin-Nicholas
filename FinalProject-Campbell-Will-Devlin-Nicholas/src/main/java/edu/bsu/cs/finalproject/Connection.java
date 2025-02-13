package edu.bsu.cs.finalproject;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Connection {
    private static String apiKey; // Store API key

    public static String weatherConnect(String zip_code) {
        ensureApiKey();
        String weatherSite = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + zip_code + "&aqi=no";
        return getJSONFromURL(constructURLFromString(weatherSite));
    }

    public static String forecastConnect(String zip_code) {
        ensureApiKey();
        String weatherSite = "http://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + zip_code + "&days=3&aqi=no&alerts=no";
        return getJSONFromURL(constructURLFromString(weatherSite));
    }

    private static void ensureApiKey() {
        if (apiKey == null) {
            // Use API key from WeatherApp if available
            apiKey = WeatherApp.getStoredApiKey();

            // Fallback: Use environment variable
            if (apiKey == null || apiKey.isEmpty()) {
                apiKey = System.getenv("WEATHER_API_KEY");
            }

            if (apiKey == null || apiKey.isEmpty()) {
                System.err.println("Error: No API key provided.");
                System.exit(1);
            }
        }
    }

    public static String getJSONFromURL(URL url) {
        try {
            URLConnection connection = url.openConnection();
            connection.connect();
            return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
        } catch (Exception exception) {
            System.err.println("Network Error");
            System.exit(0);
            return null;
        }
    }

    public static URL constructURLFromString(String url) {
        try {
            return new URI(url).toURL();
        } catch (Exception exception) {
            System.err.println("Invalid URL");
            System.exit(0);
            return null;
        }
    }
}
