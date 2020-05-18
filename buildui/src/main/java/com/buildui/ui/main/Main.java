package com.buildui.ui.main;

import com.buildui.ui.StageController;
import com.buildui.util.EnvironmentBuilderUtil;
import com.buildui.util.StageName;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        new StageController().setNewStage(StageName.LOG_IN);
    }

    public static void main(String[] args)
    {
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            Long startTime = System.currentTimeMillis();
            EnvironmentBuilderUtil ui = new EnvironmentBuilderUtil();
            System.out.println(ui.getFormatDate(startTime));
        }));
    }
}