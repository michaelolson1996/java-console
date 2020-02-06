package neumont.csc150.c.zombie.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Zombie {
    protected int armNum;
    protected int legNum;
    protected int baseHP;
    protected int speed;

    // CONSTRUCTORS

    public Zombie() {}

    public Zombie(int an, int ln, int bhp, int s) {
        setArmNum(an);
        setLegNum(ln);
        setBaseHP(bhp);
        setSpeed(s);
    }

    // NUMBER OF ARMS

    public int getArmNum() {
        return armNum;
    }

    public void setArmNum(int armNum) {
        validateArmNum(armNum);
        this.armNum = armNum;
    }

    protected void validateArmNum(int armNum) {
        if (armNum < 0 || armNum > 2)
            throw new IllegalArgumentException("Arm number must be above zero or below 2");
    }

    // NUMBER OF LEGS

    public int getLegNum() {
        return legNum;
    }

    public void setLegNum(int legNum) {
        validateLegNum(legNum);
        this.legNum = legNum;
    }

    protected void validateLegNum(int legNum) {
        if (legNum < 0 || legNum > 2)
            throw new IllegalArgumentException("Arm number must be above zero or below 2");
    }

    // BASE HP

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        validateValueInRange(baseHP, getBaseHPMin(), getBaseHPMax());
        this.baseHP = baseHP;
    }

    abstract protected int getBaseHPMin();

    abstract protected int getBaseHPMax();

    // SPEED

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        validateValueInRange(speed, getSpeedMin(), getSpeedMax());
        this.speed = speed;
    }

    abstract protected int getSpeedMin();

    abstract protected int getSpeedMax();

    // METHODS

    protected int roll(int min, int max) {
        int total = min * max;
        return ThreadLocalRandom.current().nextInt(min, total + 1);
    }

    public abstract String attack(int genRoll);

    private void validateValueInRange(int value, int min, int max) {
        if (value < min || value > max)
            throw new IllegalArgumentException(
                    String.format("Value must be between %d and %d", min, max)
            );
    }

    @Override
    public String toString() {
        return String.format("\nZombie Type : %s\nZombie Arms : %d\nZombie Legs : %d\nZombie Health : %d\nZombie Speed : %d\n%s\n",
                this.getClass().getSimpleName(),
                this.getArmNum(),
                this.getLegNum(),
                this.getBaseHP(),
                this.getSpeed(),
                this.attack(this.roll(1,20)));
    }
}
