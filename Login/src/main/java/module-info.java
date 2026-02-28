module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.login.controllers to javafx.fxml;
    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.login.controllers;
}