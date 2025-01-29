package controllers;

import dao.FloorDAO;
import dao.RoomDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import utils.SessionManager;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;



public class MainController {
    @FXML
    private BorderPane mainPane;

    @FXML
    public void initialize() {
        SessionManager.getInstance().setMainController(this);
        loadPage("/fxml/presentation.fxml");
    }

    public Object loadPage(String path){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            ScrollPane center = loader.load();
            mainPane.setCenter(center);
            return loader.getController();
        }
        catch(IOException e){
            System.err.println("Erreur lors du chargement de la page " +path+" : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    @FXML
    public void showMain(ActionEvent event) {
        loadPage("/fxml/presentation.fxml");
    }

    private void showTypeRoom(String type,String method){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(700,476);
        scrollPane.setFitToWidth(true);

        VBox mainContainer = new VBox(10);
        mainContainer.setStyle("-fx-padding: 10;-fx-background-color: #f5f5f5;");

        FloorDAO floorDAO = new FloorDAO();
        List<String> floors = floorDAO.getFloors();
        for(String floor: floors){
            Label floorLabel =new Label(floor);
            floorLabel.setFont(new Font("Lucida Calligraphy", 20));
            floorLabel.setStyle("-fx-text-fill: #333333;");

            HBox imageContainer = new HBox(10);
            imageContainer.setStyle("-fx-background-color: #e8e8e8; -fx-padding: 10; -fx-border-radius: 5; -fx-background-radius: 5;");
            imageContainer.setPrefHeight(200);
            imageContainer.setPrefWidth(Double.MAX_VALUE);

            RoomDAO roomDAO= new RoomDAO();
            Map<Integer,String> roomImages = roomDAO.retrieveRooms(type,floor);
            if (roomImages.isEmpty())
                continue;
            imageContainer = showRoomsPerFloor(imageContainer,roomImages,floor,method);
            mainContainer.getChildren().addAll(floorLabel,imageContainer);
        }
        scrollPane.setContent(mainContainer);

        mainPane.setCenter(scrollPane);
    }

    @FXML
    public void showRooms() {
        showTypeRoom(null,"showRooms");
    }

    public void showSimple(){
        showTypeRoom("Simple","showSimple");
    }

    public void showDouble(){
        showTypeRoom("Double","showDouble");
    }

    public void showFamily(){
        showTypeRoom("Family","showFamily");
    }

    public void showSpeciality(){
        showTypeRoom("Speciality","showSpeciality");
    }

    public void showSuite(){
        showTypeRoom("Suite","showSuite");
    }
    public HBox showRoomsPerFloor(HBox imageContainer,Map<Integer,String> roomImages,String floor,String method){
        for(Map.Entry<Integer,String> entry: roomImages.entrySet()){
            int roomNum = entry.getKey();
            String imagePath = entry.getValue();

            Button imageButton = new Button("Room " + roomNum);
            imageButton.setFont(new Font("Gill Sans MT", 16));
            imageButton.setStyle(
                    "-fx-text-fill: #555555; " +
                            "-fx-background-color: #e8e8e8; " +
                            "-fx-border-radius: 5; " +
                            "-fx-background-radius: 5; " +
                            "-fx-padding: 5; " +
                            "-fx-cursor: hand;"
            );

            imageButton.setOnAction(e ->((RoomInformationsController) loadPage("/fxml/roomInformations.fxml")).showRoomInformations(imagePath,roomNum,floor) );

            String absolutePath = Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm();
            ImageView image = new ImageView(new Image(absolutePath));
            image.setFitWidth(300);
            image.setFitHeight(200);
            image.setPreserveRatio(true);

            String iconPath = Objects.requireNonNull(getClass().getResource("/icons/eye.png")).toExternalForm();
            ImageView eyeIcon = new ImageView(new Image(iconPath));

            Button eyeButton = new Button();
            eyeButton.setGraphic(eyeIcon);
            eyeButton.setStyle("-fx-pref-width: 15px; -fx-pref-height: 15px; -fx-min-width: 15px; -fx-min-height: 15px;-fx-cursor: hand;");

            StackPane imageStackPane = new StackPane(image, eyeButton);
            StackPane.setAlignment(eyeButton, Pos.BOTTOM_RIGHT);
            imageStackPane.setStyle("-fx-padding: 5;");
            eyeButton.setOnAction(e -> ((RoomController) loadPage("/fxml/room.fxml")).showImagePreview(imagePath,method));

            VBox roomBox = new VBox(5);
            roomBox.getChildren().addAll(imageButton,imageStackPane);
            roomBox.setAlignment(Pos.CENTER);

            imageContainer.getChildren().add(roomBox);
        }
        return imageContainer;
    }

}

