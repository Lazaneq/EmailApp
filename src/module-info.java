module EmailApp {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.controls;
    requires activation;
    requires java.mail;

    opens App;
    opens App.view;
    opens App.controller;
}