package edu.neumont.csc150.c;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private int[] myArr;
    private int currentNum;
    private int greatestNum;
    private int currentCount;
    private double mean;
    private int mode;
    private int max;
    private int min;

    private void run() {
        myArr = new int[100];
        currentCount = 0;
        int minBound = 1;
        int maxBound = 11;
        for (int i = 0; i < myArr.length; i++) {

            myArr[i] = ThreadLocalRandom.current().nextInt(minBound,maxBound);

            if (max < myArr[i])
                max = myArr[i];

            if (myArr[0] > myArr[i])
                min = myArr[i];

            mean = mean + myArr[i];
            currentNum = myArr[i];

            for (int j = 0; j < myArr.length; j++) {
                if (currentNum == myArr[j])
                    currentCount += 1;
            }

            if (currentCount > greatestNum) {
                greatestNum = currentCount;
                mode = myArr[i];
            }
        }

        mean = mean / myArr.length;
        System.out.println(String.format("MAX : %d\nMIN : %d\nMEAN : %f\nMODE : %d",
                max, min, mean, mode));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
