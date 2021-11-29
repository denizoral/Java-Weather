package gui;

import api.WeatherApi;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox mainBox;

    @FXML
    private Label mainLabel;

    @FXML
    private Label feelsLabel;

    @FXML
    private Label descLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private ImageView weatherImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainBox.setStyle("-fx-background-color: #03f0fc;");
        WeatherApi api = new WeatherApi("London"); //add freedom of choice here later
        String[] weatherData = api.apiCall();
        mainLabel.setText(String.format("%s°C",weatherData[3]));
        feelsLabel.setText(String.format("Feels like %s°C", weatherData[4]));
        descLabel.setText(String.format("%s", weatherData[1]));
        countryLabel.setText(String.format("%s, %s", api.getCity(), api.getCountry()));
        weatherImage.setImage(new Image(api.getWeatherIconUrl()));
    }

}
