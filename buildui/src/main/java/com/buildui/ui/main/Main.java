package com.buildui.ui.main;

import com.buildui.util.EnvironmentBuilderUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    private double offSetX = 0;
    private double offSetY = 0;

    public int displayHello(int a, int b) {
        return (a * b);
    }

    @Override
    public void start(Stage stage) {
        try {
//            URL url = new File("/fxml/login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            root.getStylesheets().add(("/styles/main.css"));
            stage.initStyle(StageStyle.TRANSPARENT);

            root.setOnMousePressed(e -> {
                offSetX = e.getSceneX();
                offSetY = e.getSceneY();
            });

            root.setOnMouseDragged(e -> {
                stage.setX(e.getScreenX() - offSetX);
                stage.setY(e.getScreenY() - offSetY);
            });

            Scene scene = new Scene(root, 560, 480);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

//            new Thread(() -> {
//
//            }).start();
        } catch(Exception err) {
            System.out.println(err);
        }
    }

    public static void main(String[] args) {
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Long startTime = System.currentTimeMillis();
            EnvironmentBuilderUtil ui = new EnvironmentBuilderUtil();
            System.out.println(ui.getFormatDate(startTime));
        }));
    }
}