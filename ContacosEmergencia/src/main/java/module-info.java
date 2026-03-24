module com.example.contacosemergencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contacosemergencia to javafx.fxml;
    exports com.example.contacosemergencia;
    exports com.example.contacosemergencia.Controllers;
    opens com.example.contacosemergencia.Controllers to javafx.fxml;
}