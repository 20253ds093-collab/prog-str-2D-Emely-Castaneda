package com.example.login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class LoginController {
    @FXML private TextField txtUser, txtEmail;
    @FXML private PasswordField txtPass;
    @FXML private Label lblError;
    @FXML
    private void validarLogin() throws Exception {
        String u = txtUser.getText() == null ? "" : txtUser.getText();
        String e = txtEmail.getText() == null ? "" : txtEmail.getText();
        String p = txtPass.getText() == null ? "" : txtPass.getText();
        if (u.length() < 4) {
            lblError.setText("usuario min 4 caracteres");
            System.out.println("error usuario corto");
        } else if (!e.contains("@") || !e.contains(".")) {
            lblError.setText("correo debe incluir arroba y punto");
            System.out.println("error correo invalido");
        } else if (p.length() < 6) {
            lblError.setText("password min 6 caracteres");
            System.out.println("error password corta");
        } else {
            System.out.println("login exitoso");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));            Stage stage = (Stage) txtUser.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            DashboardController dc = loader.getController();
            dc.setMensaje("bienvenido " + u);
        }
    }
}