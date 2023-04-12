package kg.charginov.securityencrypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import kg.charginov.securityencrypt.service.EncryptionService;

public class HelloController {

    @FXML
    private Button encryptButton;

    @FXML
    private TextArea requestText;

    @FXML
    private TextArea responseText;

    @FXML
    private Label wrongText;

    private final EncryptionService encryptionService = new EncryptionService();

    @FXML
    void encryptButtonClicked(ActionEvent event) {
        if(requestText.getText().isEmpty()){
            wrongText.setVisible(true);
        }else{
            responseText.setText(encryptionService.encrypt(requestText.getText()));
        }
    }

}