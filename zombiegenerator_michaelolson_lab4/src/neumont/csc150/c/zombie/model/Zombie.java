package neumont.csc150.c.zombie.model;

abstract public class Zombie {
    protected int armNum;
    protected int legNum;
    protected int baseHP;
    protected double speed;

    public Zombie() {}

    public Zombie(int an, int ln, int bhp, double s) {
        setArmNum(an);
        setLegNum(ln);
        setBaseHP(bhp);
        setSpeed(s);
    }

    public int getArmNum() {
        return armNum;
    }

    public void setArmNum(int armNum) {
        if (armNum < 0 || armNum > 2)
            throw new IllegalArgumentException("Arm number must be above zero or below 2");
        this.armNum = armNum;
    }

    public int getLegNum() {
        return legNum;
    }

    public void setLegNum(int legNum) {
        if (legNum < 0 || legNum > 2)
            throw new IllegalArgumentException("Arm number must be above zero or below 2");
        this.legNum = legNum;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        if (baseHP <= 0)
            throw new IllegalArgumentException("Base health must be greater than zero");
        this.baseHP = baseHP;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed <= 0)
            throw new IllegalArgumentException("Speed must be greater than zero");
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Zombie Arms: %d\nZombie Legs : %d\nZombie Health : %d\nZombie Speed : %d",
                this.getArmNum(), this.getLegNum(), this.getBaseHP(), this.getSpeed());
    }
}
