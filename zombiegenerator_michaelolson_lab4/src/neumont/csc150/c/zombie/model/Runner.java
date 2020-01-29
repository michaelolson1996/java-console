package neumont.csc150.c.zombie.model;

public class Runner extends Zombie {

    public Runner() {}

    public Runner(int an, int ln, int bhp, double s) {
        super(an, ln, bhp, s);
    }

    @Override
    public String toString() {
        return "Zombie Type : Runner\n" + super.toString();
    }
}
