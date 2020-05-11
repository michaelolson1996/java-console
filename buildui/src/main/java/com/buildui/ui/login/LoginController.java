package com.buildui.ui.login;

import com.buildui.util.StageBuilder;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LoginController {

    private StageBuilder stageBuilder = new StageBuilder();

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    @FXML
    private void handleLoginButtonAction(ActionEvent actionEvent) throws Exception {
        if (validateCredentials()) {
            stageBuilder.closeStage((Stage) username.getScene().getWindow());
            stageBuilder.buildStage(new Stage(), "/fxml/dashboard.fxml", 1000, 800, true);
        }
    }

    private boolean validateCredentials() {
        return true;
    }

    private void loadSignUp() {

    }

    @FXML
    private void exit(ActionEvent actionEvent) {
        stageBuilder.closeStage((Stage) username.getScene().getWindow());
        System.exit(0);
    }
}