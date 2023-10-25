package controller;

import view.ViewLogin;

public class StartController {
    public StartController (){
        ViewLogin login = new ViewLogin();
        //--
        login.welcome.setOnAction(actionEvent ->{
            login.login();
        });

    }
}
