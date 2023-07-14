package App.controller;

import App.EmailManager;
import App.controller.services.LoginService;
import App.model.EmailAccount;
import App.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginWindowController extends BaseController implements Initializable {

    @FXML
    private TextField emailAdressField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAdressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(e -> {
                EmailLoginResult emailLoginResult = loginService.getValue();
                switch (emailLoginResult){
                    case SUCCES -> {
                        System.out.println("login succesful:" + emailAccount);
                        if(!viewFactory.isMainVieInitialized()){
                            viewFactory.showMainWindow();
                        }
                        Stage stage = (Stage) loginButton.getScene().getWindow();
                        viewFactory.closeStage(stage);
                    }
                    case FAILED_BY_CREDENTIALS -> {
                        errorLabel.setText("Failed by credentials");
                    }
                    case FAILED_UNEXPECTED -> {
                        errorLabel.setText("Unexpected error");
                    }
                    default -> {}
                }
            });

        }

    }

    private boolean fieldsAreValid() {
        if(emailAdressField.getText().isEmpty()){
            errorLabel.setText("Uzupelnij email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Uzupelnij haslo");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailAdressField.setText("testowylaz366@gmail.com");
        passwordField.setText("vzmeldytmfsndkvc");
    }
}
