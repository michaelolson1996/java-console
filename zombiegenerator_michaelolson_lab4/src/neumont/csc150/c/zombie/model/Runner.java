package neumont.csc150.c.zombie.model;

public class Runner extends Zombie {

    public Runner() {}

    public Runner(int an, int ln, int bhp, int s) {
        super(an, ln, bhp, s);
    }

    @Override
    protected int getBaseHPMin() {
        return 10;
    }

    @Override
    protected int getBaseHPMax() {
        return 22;
    }

    @Override
    protected int getSpeedMin() {
        return 15;
    }

    @Override
    protected int getSpeedMax() {
        return 25;
    }

    @Override
    public String attack(int genRoll) {
        if (genRoll < 8) {
            return "RollValue : " + genRoll + "\nMiss\n" + "Damage : 0";
        } else if (genRoll == 20) {
            return "RollValue : " + genRoll + "\nCrit\n" + "Damage : " + this.roll(2,8) * 2;
        } else {
            return "RollValue : " + genRoll + "\nHit\n" + "Damage : " + this.roll(2,8);
        }
    }

}
