package com.buildui.ui.login;

import com.buildui.ui.StageController;
import com.buildui.util.StageName;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class LoginController extends StageController {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private void handleLoginButtonAction ()
    {
        if (validateCredentials())
        {
            this.setNewStage(StageName.DASHBOARD);
        }
    }

    @FXML
    private void handleSignUpButtonAction()
    {
        this.setNewStage(StageName.SIGN_UP);
    }

    @FXML
    private void exit() {
        this.closeStage();
        System.exit(0);
    }

    private boolean validateCredentials() {
        return true;
    }
}