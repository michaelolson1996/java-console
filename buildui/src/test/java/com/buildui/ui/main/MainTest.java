package com.buildui.ui.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.File;
import java.net.URL;

@ExtendWith(ApplicationExtension.class)
public class MainTest {

    @Test
    public void shouldSayHello() {
        Main tester = new Main();

        assertEquals(0, tester.displayHello(0, 9), "should return 0");
    }


//    @DisplayName("Main Class Test")
//    @Start
//    private void start(Stage stage) throws Exception {
//        System.out.println("hello");
//    }
}