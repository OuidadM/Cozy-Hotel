package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class StartMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cozy Hotel's Application");
        String iconPath="/icons/icon.png";
        Image icon= new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
        primaryStage.getIcons().add(icon);
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
