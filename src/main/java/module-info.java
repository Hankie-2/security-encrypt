module kg.charginov.securityencrypt {
    requires javafx.controls;
    requires javafx.fxml;


    opens kg.charginov.securityencrypt to javafx.fxml;
    exports kg.charginov.securityencrypt;
}