package com.example.login;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class DashboardController {
    @FXML private Label lblBienvenida;
    public void setMensaje(String t) {
        lblBienvenida.setText(t);
        System.out.println("mostrando dashboard");
    }
}