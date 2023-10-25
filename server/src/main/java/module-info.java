module app.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;
    requires java.logging;
    requires java.sql;

    opens app to javafx.fxml;
    exports app;
    exports interfaces to java.rmi;
}