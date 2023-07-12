module EmailApp {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.controls;

    opens Test;
    opens Test.view;
}