package api;

import parser.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherApi {

    public WeatherApi() {}


    public WeatherApi(String city) {
        setCity(city);
    }

    private static final String API_KEY = "4954bd7d5f06c6b134eee397d8d43f4f";

    private String country = "";
    private String city = "";
    private String iconId = "";
    private String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=" + API_KEY;
    private String forecastUrl = "api.openweathermap.org/data/2.5/forecast?q=%s&units=metric&appid=" + API_KEY;
    private String weatherIconUrl = "http://openweathermap.org/img/wn/%s@2x.png";

    private void setCountry(String country) {
        this.country = country;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setWeatherIcon(String iconId) {
        this.iconId = iconId;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getWeatherIconUrl() {
        return String.format(weatherIconUrl, iconId);
    }

    public String[] apiCall() {
        URL url;
        StringBuilder jsonData = new StringBuilder();
        try {
            url = new URL(String.format(apiUrl, getCity()));
            System.out.println(url);

            //Open a URL connection and receive the data.
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            //decode the url data
            while ((inputLine = in.readLine()) != null) {
                jsonData.append(inputLine);
            }

            //closing the input stream
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parser parser = new Parser();

        String[] weatherData = parser.parseWeather(jsonData.toString());

        setCountry(weatherData[5]);
        setWeatherIcon(weatherData[2]);

        return weatherData;
    }

}
