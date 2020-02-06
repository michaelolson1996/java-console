package neumont.csc150.c.zombie.model;

public class Tank extends Zombie {

    public Tank() {}

    public Tank(int an, int ln, int bhp, int s) {
        super(an, ln, bhp, s);
    }

    @Override
    protected int getBaseHPMin() {
        return 45;
    }

    @Override
    protected int getBaseHPMax() {
        return 70;
    }

    @Override
    protected int getSpeedMin() {
        return 4;
    }

    @Override
    protected int getSpeedMax() {
        return 8;
    }

    @Override
    public String attack(int genRoll) {
        if (genRoll < 10) {
            return "RollValue : " + genRoll + "\nMiss\n" + "Damage : 0";
        } else if (genRoll == 20) {
            return "RollValue : " + genRoll + "\nCrit\n" + "Damage : " + this.roll(3,6) * 3;
        } else {
            return "RollValue : " + genRoll + "\nHit\n" + "Damage : " + this.roll(3,6);
        }
    }

}
