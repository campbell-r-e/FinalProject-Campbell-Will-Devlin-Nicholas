package edu.bsu.cs.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WeatherController {
    @FXML
    private TextField zipCodeTextField;

    @FXML
    private Label weatherLabel = new Label("rt");
//
    @FXML
    private ComboBox<Object> comboBox = new ComboBox<>();



    @FXML
    private void getWeather() {
        String rawWeatherData = Connection.weatherConnect(zipCodeTextField.getText());
        if(zipCodeTextField.getText() == null){
            displayErrorMessage("No zip Code was entered please try again!");
        }
        if (!JSONParser.checkValidZipCode(rawWeatherData)) {
            System.err.println("Invalid ZIP Code! :(");
            return;
        }
        String tempUnit = (String) comboBox.getValue();
        String parsedWeatherInfo = JSONParser.dataFormatter(rawWeatherData, tempUnit);
        displayWeatherInfo(parsedWeatherInfo);
    }
    private void displayWeatherInfo(String weatherInfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Weather Information");
        alert.setHeaderText("Weather Details");
        alert.setContentText(weatherInfo);
        Stage stage = (Stage) weatherLabel.getScene().getWindow();
        alert.initOwner(stage);
        alert.showAndWait();
    }


    public void displayErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) weatherLabel.getScene().getWindow();
        alert.initOwner(stage);
        alert.showAndWait();

    }
    @FXML
    public void forecastConnect() {
        String zipCode = zipCodeTextField.getText();
        if(zipCode == null){
            displayErrorMessage("No zip Code was entered please try again!");
        }
        String forecastData = Connection.forecastConnect(zipCode);
        String parsedForecastInfo = JSONParser.forecastFormatter(forecastData);
        displayWeatherInfo(parsedForecastInfo);
    }




    public void end(){
        System.exit(0);
    }
}
