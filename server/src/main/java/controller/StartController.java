package controller;

import view.ViewServer;

public class StartController {
    public StartController() {
        ViewServer login = new ViewServer();
        login.welcome.setOnAction(actionEvent -> {
            login.login();
        });
    }
}
