package com.buildui.ui.login;

import com.buildui.util.ResizeListener;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    @FXML
    private void handleLoginButtonAction(ActionEvent actionEvent) {
        if (validateCredentials()) {
            closeStage();
            loadMain();
        }
    }

    private boolean validateCredentials() {
        return true;
    }

    private void loadMain() {
        try {
            ResizeListener rl = new ResizeListener();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            root.getStylesheets().add(("/styles/main.css"));
            root.setOnMouseDragged(rl);
            root.setOnMousePressed(rl);
            root.setOnMouseMoved(rl);
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root, 1000, 800));
            stage.show();
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

    @FXML
    private void exit(ActionEvent actionEvent) {
        ((Stage) username.getScene().getWindow()).close();
        System.exit(0);
    }
}