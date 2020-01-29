package edu.neumont.csc150.c.fruit.test;

import edu.neumont.csc150.c.fruit.model.Apple;
import edu.neumont.csc150.c.fruit.model.Fruit;
import edu.neumont.csc150.c.fruit.model.Orange;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        Fruit fijiApple = new Apple("Fiji Apple", 0.45, "Red", true, 8, true);
        Fruit grannyApple = new Apple("Granny Apple", 0.32, "Green", false, 12, false);
        Fruit sunnyOrange = new Orange("Sunny Orange", 0.65, "Orange", false, 14, 0.34);
        Fruit floridaOrange = new Orange("Florida Orange", 0.34, "Maroon", true, 18, 0.23);
        Fruit banana = new Fruit("banana", 0.33, "Yellow", false, 0);
        Fruit strawberry = new Fruit("strawberry", 0.12, "Red", true, 390);
//        ((Apple) fijiApple).setFiji(true);
//        ((Apple) grannyApple).setFiji(false);
//        ((Orange) sunnyOrange).setPeelThickness(0.3);
//        ((Orange) floridaOrange).setPeelThickness(0.4);

        List<Fruit> myFruitList = new ArrayList<>();
        myFruitList.add(fijiApple);
        myFruitList.add(grannyApple);
        myFruitList.add(sunnyOrange);
        myFruitList.add(floridaOrange);
        myFruitList.add(banana);
        myFruitList.add(strawberry);

        for (Fruit f : myFruitList) {
            if (f instanceof Apple) {
                ((Apple) f).clean();
            }
        }

        System.out.println(fijiApple.toString());
        System.out.println(sunnyOrange.toString());
        System.out.println(strawberry.toString());
    }
}
