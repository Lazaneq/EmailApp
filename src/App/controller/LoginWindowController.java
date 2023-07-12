package App.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {

    @FXML
    private TextField emailAdressField;

    @FXML
    private Button errorButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginButtonAction() {
        System.out.println("click");
    }

}
