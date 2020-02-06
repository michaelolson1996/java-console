package neumont.csc150.c.zombie.model;

public class Walker extends Zombie {

    public Walker() {}

    public Walker(int an, int ln, int bhp, int s) {
        super(an, ln, bhp, s);
    }

    @Override
    protected int getBaseHPMin() {
        return 15;
    }

    @Override
    protected int getBaseHPMax() {
        return 30;
    }

    @Override
    protected int getSpeedMin() {
        return 6;
    }

    @Override
    protected int getSpeedMax() { return 10; }

    @Override
    public String attack(int genRoll) {
        if (genRoll < 5) {
            return "RollValue : " + genRoll + "\nMiss\n" + "Damage : 0";
        } else if (genRoll >= 19) {
            return "RollValue : " + genRoll + "\nCrit\n" + "Damage : " + this.roll(3,6) * 2;
        } else {
            return "RollValue : " + genRoll + "\nHit\n" + "Damage : " + this.roll(3,6);
        }
    }

}
