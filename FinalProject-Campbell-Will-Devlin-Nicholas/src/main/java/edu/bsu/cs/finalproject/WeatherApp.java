package edu.bsu.cs.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.Optional;

public class WeatherApp extends Application {
    private static final Logger logger = LogManager.getLogger(WeatherApp.class);
    private static String apiKey; // Store API key

    public static void main(String[] args) {
        launch(args); // Start JavaFX GUI
    }

    @Override
    public void start(Stage stage) {
        apiKey = promptForApiKey();

        if (apiKey == null || apiKey.isEmpty()) {
            logger.error("No API key entered. Exiting...");
            System.exit(1);
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/weather_gui.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setTitle("Weather Application");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            logger.error("An I/O exception occurred while loading the GUI.", e);
        }
    }

    private String promptForApiKey() {
        // Check if API key is already set via environment variable
        String envApiKey = System.getenv("WEATHER_API_KEY");
        if (envApiKey != null && !envApiKey.isEmpty()) {
            return envApiKey;
        }

        // Open a dialog box to ask the user for API key
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("API Key Required");
        dialog.setHeaderText("Enter your Weather API Key");
        dialog.setContentText("API Key:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }

    public static String getStoredApiKey() {
        return apiKey;
    }
}
