module app.operador{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.rmi;

    opens app to javafx.fxml;
    exports app;
}