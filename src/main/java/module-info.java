module com.example.tp2graphique {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.tp2graphique.Models;
    opens com.example.tp2graphique to javafx.fxml;
    exports com.example.tp2graphique;
}