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
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;

    private boolean mainViewInitialized = false;
    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<>();
    }

    public boolean isMainVieInitialized(){
        return mainViewInitialized;
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
        mainViewInitialized = true;
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
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for(Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(getColorTheme().getCssPath()).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(getFontSize().getCssPath()).toExternalForm());
        }
    }
}
