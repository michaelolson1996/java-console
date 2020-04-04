package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Random;

public class Controller implements EventHandler<ActionEvent> {

    @FXML
    private Canvas mainCanvas;

    private GraphicsContext g;

    private int ballX = 30, ballY = 30, ballSize = 80;
    private int ballVx = 2, ballVy = 2;

    private Timeline timer;
    private Random rng = new Random();

    @FXML
    public void initialize() {
        g = mainCanvas.getGraphicsContext2D();
        timer = new Timeline(new KeyFrame(Duration.millis(10), this));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        draw();
    }

    @Override
    public void handle(ActionEvent event) {
        ballX += ballVx;
        checkXCollision();
        ballY += ballVy;
        checkYCollision();
        draw();
    }

    private void checkXCollision() {
        if (ballX + ballSize >= this.mainCanvas.getWidth() || ballX <= 0) {
            ballVx *= -1;
        }
    }

    private void checkYCollision() {
        if ((ballY + ballSize >= this.mainCanvas.getHeight()) || (ballY <= 0)) {
            ballVy *= -1;
        }
    }

    public void draw() {
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, this.mainCanvas.getWidth(), this.mainCanvas.getHeight());
        g.setFill(Color.BLACK);
        g.fillText("DVD", ballX + (ballSize / 2), ballY + (ballSize / 2));
//        g.setFill(Color.BLUE);
        g.setFill(new Color(rng.nextDouble(),rng.nextDouble(),rng.nextDouble(),rng.nextDouble()));
        g.fillOval(ballX, ballY, ballSize, ballSize);
    }
}