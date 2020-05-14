package com.buildui.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageBuilder {

    private ResizeListener rl;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private FXMLLoader loader;
    private double offSetX = 0;
    private double offSetY = 0;

    public StageBuilder() {}

    public Stage getStage() {
        return this.stage;
    }

    public void buildStage(String location,
                           int width,
                           int height,
                           boolean isResizable) throws Exception
    {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getResource(location));
        this.root = loader.load();
        this.rl = new ResizeListener();
        this.stage = new Stage();
        this.stage.initStyle(StageStyle.TRANSPARENT);

        if (isResizable)
        {
            this.root.setOnMouseDragged(this.rl);
            this.root.setOnMousePressed(this.rl);
            this.root.setOnMouseMoved(this.rl);
            this.root.setOnMouseReleased(this.rl);
        }
        else
        {
            this.root.setOnMousePressed(e ->
            {
                this.offSetX = e.getSceneX();
                this.offSetY = e.getSceneY();
            });

            this.root.setOnMouseDragged(e ->
            {
                this.stage.setX(e.getScreenX() - this.offSetX);
                this.stage.setY(e.getScreenY() - this.offSetY);
            });
        }

        this.scene = new Scene(this.root, width, height);
        this.stage.setScene(scene);
        this.stage.setResizable(isResizable);
        this.stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
