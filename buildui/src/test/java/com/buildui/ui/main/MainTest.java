package com.buildui.ui.main;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.testfx.framework.junit5.ApplicationExtension;

//@ExtendWith(ApplicationExtension.class)
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