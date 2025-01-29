package controllers;

import dao.RoomDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import models.User;
import utils.SessionManager;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class RoomInformationsController {
    @FXML
    private ImageView roomImage;
    @FXML
    private Label room;
    @FXML
    private Label type;
    @FXML
    private Label floorLabel;
    @FXML
    private Label state;
    @FXML
    private Label price;
    @FXML
    private Text description;
    @FXML
    private Button view;

    void showRoomInformations(String imagePath, int num, String floor) {
        String absolutePath = Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm();
        Image image = new Image(absolutePath);
        roomImage.setImage(image);

        RoomDAO roomDAO = new RoomDAO();
        Map<String, String> roomInformations = roomDAO.retrieveRoomInformations(num);

        room.setText("Room " + num);
        type.setText(roomInformations.get("type"));
        floorLabel.setText(floor);
        state.setText("State: "+roomInformations.get("state"));
        if (roomInformations.get("state").equals("Free"))
            state.setStyle("-fx-text-fill:  #32cd32;");
        else
            state.setStyle("-fx-text-fill: red;");
        price.setText("Price: " + roomInformations.get("price"));
        description.setText(roomInformations.get("description"));
        MainController main = SessionManager.getInstance().getMainController();
        view.setOnAction(e -> ((RoomController) main.loadPage("/fxml/room.fxml")).showImagePreviewRoom(imagePath, num, floor));
    }

    @FXML
    public void bookRoom(ActionEvent event) {
        User currentUser = SessionManager.getInstance().getCurrentUser();
        if (currentUser == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sign_in.fxml"));
                DialogPane dialogPane = loader.load();
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.setDialogPane(dialogPane);


                dialog.showAndWait();
            } catch (IOException ex) {
                System.err.println("Error while loading Sign in dialog page : " + ex.getMessage());
            }
        }

    }
}
