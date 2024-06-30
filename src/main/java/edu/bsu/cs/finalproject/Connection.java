package edu.bsu.cs.finalproject;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Objects;

public class Connection
{
    public static String weatherConnect(String zip_code)
    {
        String key = readAPIKey();
        String weatherSite = "http://api.weatherapi.com/v1/current.json?key=" + key + "&q=" + zip_code + "&aqi=no";
        return getJSONFromURL(constructURLFromString(weatherSite));
    }
    public static String forecastConnect(String zip_code)
    {
        String key = readAPIKey();
        String weatherSite = "http://api.weatherapi.com/v1/forecast.json?key=" + key + "&q=" + zip_code + "&days=3&aqi=no&alerts=no";
        return getJSONFromURL(constructURLFromString(weatherSite));
    }
    public static String getJSONFromURL(URL url)
    {
        try
        {
            URLConnection connection = url.openConnection();
            connection.connect();
            return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
        }
        catch(Exception exception)
        {
            System.err.println("Network Error");
            System.exit(0);
            return null;
        }
    }
    public static URL constructURLFromString(String url)
    {
        try
        {
            return new URI(url).toURL();
        }
        catch(Exception exception)
        {
            System.err.println("Invalid URL");
            System.exit(0);
            return null;
        }
    }
    public static String readAPIKey()
    {
        try
        {
            InputStream sampleFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("api_key.txt");
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
        catch(Exception exception)
        {
            System.err.println("Can't find API key.");
            System.exit(0);
            return null;
        }
    }
}
