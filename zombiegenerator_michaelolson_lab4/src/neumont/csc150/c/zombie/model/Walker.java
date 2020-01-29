package neumont.csc150.c.zombie.model;

public class Walker extends Zombie {

    public Walker() {}

    public Walker(int an, int ln, int bhp, double s) {
        super(an, ln, bhp, s);
    }

    @Override
    public String toString() {
        return "Zombie Type : Walker\n" + super.toString();
    }
}
