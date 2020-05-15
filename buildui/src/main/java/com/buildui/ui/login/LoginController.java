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
    private void handleLoginButtonAction ()
    {
        try
        {
            if (validateCredentials())
            {
                stageBuilder.closeStage((Stage) username.getScene().getWindow());
                stageBuilder.buildStage( "/fxml/dashboard.fxml", 1000, 800, true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSignUpButtonAction() {
        try
        {
            stageBuilder.closeStage((Stage) username.getScene().getWindow());
            stageBuilder.buildStage("/fxml/signup.fxml", 650, 700, false);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void exit() {
        stageBuilder.closeStage((Stage) username.getScene().getWindow());
        System.exit(0);
    }

    private boolean validateCredentials() {
        return true;
    }
}