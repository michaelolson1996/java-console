package com.buildui.ui.controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class DashboardController extends Application {

    private BorderPane bp;
    private Group root;

    private void menuBar() {

    }

    public void initializeComponents() {
        this.bp = new BorderPane();
        this.root = new Group();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            initializeComponents();
//            this.bp.setTop(menuBar());
            this.root.getChildren().add(this.bp);
            primaryStage.setScene(new Scene(this.root, 750, 675));
            primaryStage.setTitle("DashBoard");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
