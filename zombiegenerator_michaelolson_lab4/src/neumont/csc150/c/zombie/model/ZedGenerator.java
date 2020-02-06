package neumont.csc150.c.zombie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ZedGenerator {
    private List<Zombie> horde = new ArrayList<>();

    public void generateRandZombie() {
        switch(getRandNum(0, 2)) {
            case 0:
                horde.add(new Walker(getRandNum(0, 2), getRandNum(0, 2), getRandNum(15, 30), getRandNum(6, 10)));
                break;
            case 1:
                horde.add(new Runner(getRandNum(0, 2), getRandNum(0, 2), getRandNum(10, 22), getRandNum(15, 25)));
                break;
            case 2:
                horde.add(new Tank(getRandNum(0, 2), getRandNum(0, 2), getRandNum(45, 70), getRandNum(4, 8)));
                break;
        }
    }

    public int getRandNum(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void generateOneZombie() {
        generateRandZombie();
    }

    public void generateSomeZombies() {
        int count = getRandNum(0, 10);

        for (int i = 0; i < count; i++) {
            generateRandZombie();
        }
    }

    public void generateNZombies(int count) {
        for (int i = 0; i < count; i++) {
            generateRandZombie();
        }
    }

    public void clearHorde() {
        horde.clear();
    }

    public String displayHorde() {
        StringBuilder zombieSB = new StringBuilder();
        for (Zombie z : horde) {
            zombieSB.append(z.toString());
        }
        return zombieSB.toString();
    }
}
