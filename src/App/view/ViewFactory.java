package App.view;

import App.EmailManager;
import App.controller.BaseController;
import App.controller.LoginWindowController;
import App.controller.MainWindowController;
import App.controller.OptionWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    //Zarzadzanie opcjami
    private ColorTheme colorTheme = ColorTheme.STANDARDOWY;
    private FontSize fontSize = FontSize.MID;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }
    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }
    public FontSize getFontSize() {
        return fontSize;
    }
    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }


    public void showLoginWindow(){
        System.out.println("show login");
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");

        initializeStage(controller);
    }
    public void showMainWindow(){
        System.out.println("main window");
        BaseController controller = new MainWindowController(emailManager,this,"MainWindow.fxml");

        initializeStage(controller);
    }
    public void showOptionWindow(){
        System.out.println("option window");
        BaseController controller = new OptionWindowController(emailManager,this,"OptionWindow.fxml");

        initializeStage(controller);
    }
    private void initializeStage(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        }catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Okno");
        stage.show();
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
    }
}
