package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.SessionManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class RoomController {
    @FXML
    private ImageView roomImage;

    @FXML
    private Button closeButton;

    void showImagePreview(String imagePath,String method) {
        MainController main= SessionManager.getInstance().getMainController();
        String BigImageURL = new StringBuilder(imagePath).insert(8,"agrondies/").toString();
        String absolutePath = Objects.requireNonNull(getClass().getResource(BigImageURL)).toExternalForm();
        Image largeImage = new Image(absolutePath);
        roomImage.setImage(largeImage);
        closeButton.setOnAction(e -> {
            try {
                Method declaredMethod = main.getClass().getDeclaredMethod(method);
                System.out.println("Method found: " + declaredMethod.getName());
                Object result = declaredMethod.invoke(main);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                System.out.println("Error is launched");
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        });
    }
    void showImagePreviewRoom(String imagePath,int num,String floor){
        String BigImageURL = new StringBuilder(imagePath).insert(8,"agrondies/").toString();
        String absolutePath = Objects.requireNonNull(getClass().getResource(BigImageURL)).toExternalForm();
        Image largeImage = new Image(absolutePath);
        roomImage.setImage(largeImage);
        MainController main=SessionManager.getInstance().getMainController();
        closeButton.setOnAction(e -> ((RoomInformationsController) main.loadPage("/fxml/roomInformations.fxml")).showRoomInformations(imagePath,num,floor));
    }
}
