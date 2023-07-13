package App;

import App.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showOptionWindow();
        viewFactory.updateStyles();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
