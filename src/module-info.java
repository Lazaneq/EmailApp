module EmailApp {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.controls;

    opens App;
    opens App.view;
    opens App.controller;
}