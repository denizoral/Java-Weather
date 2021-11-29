package api;

public class Main {
    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi("London"); //for testing purposes
        weatherApi.apiCall();
    }
}
