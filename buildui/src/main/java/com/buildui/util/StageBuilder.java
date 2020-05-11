package com.buildui.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageBuilder {

    private ResizeListener rl = new ResizeListener();
    private double offSetX = 0;
    private double offSetY = 0;

    public StageBuilder() {}

    public void buildStage(
            Stage stage,
            String location,
            int width,
            int height,
            boolean isResizable) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(location));
        Parent root = loader.load();
        stage.initStyle(StageStyle.TRANSPARENT);

        if (isResizable) {
            root.setOnMouseDragged(rl);
            root.setOnMousePressed(rl);
            root.setOnMouseMoved(rl);
            root.setOnMouseReleased(rl);
        }
        else {
            root.setOnMousePressed(e -> {
                offSetX = e.getSceneX();
                offSetY = e.getSceneY();
            });

            root.setOnMouseDragged(e -> {
                stage.setX(e.getScreenX() - offSetX);
                stage.setY(e.getScreenY() - offSetY);
            });
        }

        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setResizable(isResizable);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
