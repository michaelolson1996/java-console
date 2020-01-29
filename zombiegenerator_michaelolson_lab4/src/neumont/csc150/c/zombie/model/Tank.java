package neumont.csc150.c.zombie.model;

public class Tank extends Zombie {

    public Tank() {}

    public Tank(int an, int ln, int bhp, double s) {
        super(an, ln, bhp, s);
    }

    @Override
    public String toString() {
        return "Zombie Type : Tank\n" + super.toString();
    }
}
