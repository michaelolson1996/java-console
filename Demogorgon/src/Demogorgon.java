import java.util.ArrayList;
import java.util.Arrays;

public class Demogorgon {
    public int countFlyTrapFlaps;
    public double clawsLength;
    public boolean isElbowStabber;
    public ArrayList<String> powers;
    public enum Size {
        LITTLE,
        BIG
    }
    Size mySize;

    public Demogorgon() {
        setCountFlyTrapFlaps(6);
        setElbowStabber(true);
        setClawsLength(34.85);
        setPowers(new ArrayList<String>(Arrays.asList("jump", "hop", "skip")));
        setSize(0);
    }

    public Demogorgon(int countFlyTrapFlaps, double clawsLength, boolean isElbowStabber, ArrayList powers, double size) {
        setCountFlyTrapFlaps(countFlyTrapFlaps);
        setClawsLength(clawsLength);
        setElbowStabber(isElbowStabber);
        setPowers(powers);
        setSize(size);
    }

    public void setSize(double size) {
        if (size > .5) {
            this.mySize = Size.BIG;
        } else {
            this.mySize = Size.LITTLE;
        }
    }

    public Size getSize() {
        return mySize;
    }

    public int getCountFlyTrapFlaps() {
        return countFlyTrapFlaps;
    }

    public void setCountFlyTrapFlaps(int countFlyTrapFlaps) {
        this.countFlyTrapFlaps = countFlyTrapFlaps;
    }

    public double getClawsLength() {
        return clawsLength;
    }

    public void setClawsLength(double clawsLength) {
        this.clawsLength = clawsLength;
    }

    public boolean getIsElbowStabber() {
        return isElbowStabber;
    }

    public void setElbowStabber(boolean elbowStabber) {
        isElbowStabber = elbowStabber;
    }

    public ArrayList<String> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<String> powers) {
        this.powers = powers;
    }

    public void yell() {
        System.out.println("Ralp");
    }

    public String toString() {
        return  "Fly Trap Flaps: " + this.getCountFlyTrapFlaps() + "\n" +
                "Has an Elbow Stabber: " + this.getIsElbowStabber() + "\n" +
                "Length of Claws: " + this.getClawsLength() + "\n" +
                "Powers: " + this.getPowers() + "\n" +
                "Size: " + this.getSize().toString().toLowerCase();
    }
}
