module EmailApp {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.controls;
    requires activation;
    requires java.mail;
    requires java.desktop;

    opens App;
    opens App.view;
    opens App.controller;
    opens App.model;
}