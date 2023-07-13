package App.controller;


import App.EmailManager;
import App.view.ColorTheme;
import App.view.FontSize;
import App.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController extends BaseController implements Initializable {


    @FXML
    private Button acceptButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Slider fontSizePick;

    @FXML
    private ChoiceBox<ColorTheme> themePick;

    @FXML
    void applyBtnAction() {
        viewFactory.setColorTheme(themePick.getValue());
        viewFactory.setFontSize(FontSize.values()[(int) (fontSizePick.getValue())]);
        System.out.println((viewFactory.getColorTheme()));
        System.out.println(viewFactory.getFontSize());
        viewFactory.updateStyles();
    }
    @FXML
    void cancelBtnAction() {
        Stage stage = (Stage) fontSizePick.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    public OptionWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpThemePicker();
        setUpSizePicker();
}

    private void setUpSizePicker() {
        fontSizePick.setMin(0);
        fontSizePick.setMax(FontSize.values().length -1);
        fontSizePick.setValue(viewFactory.getFontSize().ordinal());
        fontSizePick.setMajorTickUnit(1);
        fontSizePick.setMinorTickCount(0);
        fontSizePick.setBlockIncrement(1);
        fontSizePick.setSnapToTicks(true);
        fontSizePick.setShowTickMarks(true);
        fontSizePick.setShowTickLabels(true);
        fontSizePick.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        fontSizePick.valueProperty().addListener((obs, oldVal, newVal) -> {
            fontSizePick.setValue(newVal.intValue());
        });

    }

    private void setUpThemePicker() {
        themePick.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePick.setValue(viewFactory.getColorTheme());
    }
    }



