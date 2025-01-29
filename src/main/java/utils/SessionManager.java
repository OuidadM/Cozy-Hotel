package utils;

import controllers.MainController;
import models.User;

public class SessionManager {
    private static SessionManager instance;
    private static MainController mainController;
    private static User authenticatedUser;
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    public void setMainController(MainController main){
        mainController = main;
    }
    public MainController getMainController(){
        return mainController;
    }
    public User getCurrentUser(){
        return authenticatedUser;
    }
}
