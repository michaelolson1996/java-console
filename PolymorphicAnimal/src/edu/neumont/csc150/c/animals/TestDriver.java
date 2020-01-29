package edu.neumont.csc150.c.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDriver {

    private static Random gen = new Random();

    public static void main(String[] args) {

        List<Animal> animals = generateRandomAnimals(100);

        for (Animal a : animals) {
            System.out.println(a.speak());
        }
    }

    private static List<Animal> generateRandomAnimals(int howMany) {
        List<Animal> results = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            Animal r;
            int currentAnimal = gen.nextInt(4) + 1;

            switch(currentAnimal) {
                case 1:
                    r = new Snake();
                    break;
                case 2:
                    r = new Giraffe();
                    break;
                case 3:
                    r = new Hedgehog();
                    break;
                case 4:
                    r = new Octopus();
                    break;
                default:
                    r = new Snake();
                    break;
            }

            r.setHasTail(gen.nextBoolean());
            r.setCountLimbs(gen.nextInt(4));
            r.setName("" + (char)(gen.nextInt(26) + 65)); // 65 - 90 inclusive
            results.add(r);
        }

        return results;
    }
}
