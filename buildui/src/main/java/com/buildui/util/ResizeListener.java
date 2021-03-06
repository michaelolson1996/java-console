package com.buildui.util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 *
 */

public class ResizeListener implements EventHandler<MouseEvent> {

    private double doubleX, doubleY, deltaX, deltaY, offSetX, offSetY;
    private boolean moveH, moveV, resizeH, resizeV, moveX, moveY;
    private double resizeBorder = 10;
    private double moveBorder = 100;
    private Scene scene;

    @Override
    public void handle(MouseEvent event) {

        Stage stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = stage.getScene();

        if (MouseEvent.MOUSE_MOVED.equals(event.getEventType())) {

            // top left corner
            if (event.getX() < resizeBorder && event.getY() < resizeBorder) {
                scene.setCursor(Cursor.NW_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = true;
                moveV = true;
            }
            // bottom left corner
            else if (event.getX() < resizeBorder && event.getY() > scene.getHeight() - resizeBorder) {
                scene.setCursor(Cursor.SW_RESIZE);
                resizeV = true;
                resizeH = true;
                moveH = true;
                moveV = false;
            }
            // top right corner
            else if (event.getX() > scene.getWidth() - resizeBorder && event.getY() < resizeBorder) {
                scene.setCursor(Cursor.NE_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = false;
                moveV = true;
            }
            // bottom right corner
            else if (event.getX() > scene.getWidth() - resizeBorder && event.getY() > scene.getHeight() - resizeBorder) {
                scene.setCursor(Cursor.SE_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = false;
                moveV = false;
            }
            // right & left
            else if (event.getX() < resizeBorder || event.getX() > scene.getWidth() - resizeBorder) {
                scene.setCursor(Cursor.E_RESIZE);
                resizeH = true;
                resizeV = false;
                moveH = (event.getX() < resizeBorder);
                moveV = false;
            }
            // top and bottom
            else if (event.getY() < resizeBorder || event.getY() > scene.getHeight() - resizeBorder) {
                scene.setCursor(Cursor.N_RESIZE);
                resizeH = false;
                resizeV = true;
                moveH = false;
                moveV = (event.getY() < resizeBorder);
            }

            else {
                scene.setCursor(Cursor.DEFAULT);
                resizeV = false;
                resizeH = false;
                moveV = false;
                moveH = false;
            }
        }
        else if (MouseEvent.MOUSE_PRESSED.equals(event.getEventType())) {
            if (event.getY() < moveBorder && event.getY() > resizeBorder) {
                offSetX = event.getSceneX();
                offSetY = event.getSceneY();
                moveX = true;
                moveY = true;
            }
            else {
                doubleX = stage.getWidth() - event.getX();
                doubleY = stage.getHeight() - event.getY();
            }
        }
        else if (MouseEvent.MOUSE_DRAGGED.equals(event.getEventType())) {
            if (resizeH && resizeV) {
                horizontalResize(stage, event);
                verticalResize(stage, event);
            }
            else if (resizeH) {
                horizontalResize(stage, event);
            }
            else if (resizeV) {
                verticalResize(stage, event);
            }
            else if (moveX && moveY) {
                stage.setX(event.getScreenX() - offSetX);
                stage.setY(event.getScreenY() - offSetY);
            }
        }
        else if (MouseEvent.MOUSE_RELEASED.equals(event.getEventType())) {
            moveX = false;
            moveY = false;
        }
    }

    private void horizontalResize(Stage stage, MouseEvent event) {
        if (stage.getWidth() <= 200) {
            if (moveH) {
                deltaX = stage.getX() - event.getScreenX();
                if (event.getX() < 0) {
                    stage.setWidth(deltaX + stage.getWidth());
                    stage.setX(event.getScreenX());
                }
            }
            else {
                if (event.getX() + doubleX - stage.getWidth() > 0) {
                    stage.setWidth(event.getX() + doubleX);
                }
            }
        }
        else if (stage.getWidth() > 200) {
            if (moveH) {
                deltaX = stage.getX() - event.getScreenX();
                stage.setWidth(deltaX + stage.getWidth());
                stage.setX(event.getScreenX());
            }
            else {
                stage.setWidth(event.getX() + doubleX);
            }
        }
    }

    private void verticalResize(Stage stage, MouseEvent event) {
        if (stage.getHeight() <= 200) {
            if (moveV) {
                deltaY = stage.getY() - event.getScreenY();
                if (event.getY() < 0) {
                    stage.setHeight(deltaY + stage.getHeight());
                    stage.setY(event.getScreenY());
                }
            }
            else {
                if (event.getY() + doubleY - stage.getHeight() > 0) {
                    stage.setHeight(event.getY() + doubleY);
                }
            }
        }
        else if (stage.getHeight() > 200) {
            if (moveV) {
                deltaY = stage.getY() - event.getScreenY();
                stage.setHeight(deltaY + stage.getHeight());
                stage.setY(event.getScreenY());
            }
            else {
                stage.setHeight(event.getY() + doubleY);
            }
        }
    }
}