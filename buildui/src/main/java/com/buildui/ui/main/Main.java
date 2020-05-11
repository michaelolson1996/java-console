package com.buildui.ui.main;

import com.buildui.util.EnvironmentBuilderUtil;
import com.buildui.util.StageBuilder;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            new StageBuilder().buildStage(stage,"/fxml/login.fxml", 560, 480, false);
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