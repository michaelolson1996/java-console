package com.buildui.ui.main;

//import com.jfoenix.controls.JFXHamburger;
//import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import java.net.URL;
//import java.util.ResourceBundle;
import com.jfoenix.controls.JFXHamburger;
//import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private VBox navdrawer;

    @FXML
    private void handlePageChange(ActionEvent event) {
        System.out.println(event.toString().contains("Dashboard"));
    }

    @FXML
    private void minimize(ActionEvent actionEvent) {
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    private void maximize(ActionEvent actionEvent) {
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).setFullScreen(true);
    }

    @FXML
    private void exit(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        ((Stage) node.getScene().getWindow()).close();
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HamburgerBasicCloseTransition burgerTask = new HamburgerBasicCloseTransition(hamburger);
        burgerTask.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            burgerTask.setRate(burgerTask.getRate() * -1);
            burgerTask.play();
            if (burgerTask.getRate() > 0)
                navdrawer.setVisible(true);
            else
                navdrawer.setVisible(false);
        });
    }
}