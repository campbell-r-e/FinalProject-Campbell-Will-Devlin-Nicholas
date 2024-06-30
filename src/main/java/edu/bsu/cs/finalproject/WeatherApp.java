package edu.bsu.cs.finalproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class WeatherApp extends Application {
    Logger logger = LogManager.getLogger(WeatherApp.class);
    public void start(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/weather_gui.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Weather Application");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

            logger.error("An I/O exception has occurred. :(");
        } catch (IllegalStateException e) {

            logger.error("An illegal state exception has occurred. :(");
        } catch (RuntimeException e) {
            logger.error("A runtime exception has occurred. :(");
        }
    }




    public static void main(String[] args) {
        launch(args);
    }




}
