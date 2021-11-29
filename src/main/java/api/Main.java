package api;

public class Main {
    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi("Ankara");
        weatherApi.apiCall();
    }
}
