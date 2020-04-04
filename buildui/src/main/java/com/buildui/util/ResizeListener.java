package com.buildui.util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ResizeListener implements EventHandler<MouseEvent> {

    private double doubleX, doubleY, deltaX, deltaY;
    private double border = 10;
    private boolean moveH, moveV;
    private boolean resizeH = false;
    private boolean resizeV = false;
    private Scene scene;

    @Override
    public void handle(MouseEvent event) {
        Stage stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = stage.getScene();
        if (MouseEvent.MOUSE_MOVED.equals(event.getEventType())) {
            // top left corner
            if (event.getX() < border && event.getY() < border) {
                scene.setCursor(Cursor.NW_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = true;
                moveV = true;
            }
            // bottom left corner
            else if (event.getX() < border && event.getY() > scene.getHeight() - border) {
                scene.setCursor(Cursor.SW_RESIZE);
                resizeV = true;
                resizeH = true;
                moveH = true;
                moveV = false;
            }
            // top right corner
            else if (event.getX() > scene.getWidth() - border && event.getY() < border) {
                scene.setCursor(Cursor.NE_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = false;
                moveV = true;
            }
            // bottom right corner
            else if (event.getX() > scene.getWidth() - border && event.getY() > scene.getHeight() - border) {
                scene.setCursor(Cursor.SE_RESIZE);
                resizeH = true;
                resizeV = true;
                moveH = false;
                moveV = false;
            }
            else if (event.getX() < border || event.getX() > scene.getWidth() - border) {
                scene.setCursor(Cursor.E_RESIZE);
                resizeH = true;
                resizeV = false;
//                moveH = (event.getX() < border);
                moveV = false;
            }
            else if (event.getY() < border || event.getY() > scene.getHeight() - border) {
                scene.setCursor(Cursor.N_RESIZE);
                resizeH = false;
                resizeV = true;
                moveH = false;
//                moveV = (event.getY() < border);
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
            doubleX = stage.getWidth() - event.getX();
            doubleY = stage.getHeight() - event.getY();
        }
        else if (MouseEvent.MOUSE_DRAGGED.equals(event.getEventType())) {
            if (resizeH) {
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
            else if (resizeV) {
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
            else if (stage.getWidth() > 100) {
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
    }
}