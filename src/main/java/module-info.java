module com.example.gestion_dechet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.gestion_dechet to javafx.fxml;
    exports com.example.gestion_dechet;
}