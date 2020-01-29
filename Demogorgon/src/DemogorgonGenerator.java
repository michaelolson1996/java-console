import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DemogorgonGenerator {
    public static void main(String[] args) throws IOException {
        boolean isActive = true;

        randDemogorgonGen();

        System.out.println(
                "[a] | Create a random Demogorgon\n" +
                "[b] | Create the default Demogorgon\n" +
                "[c] | Exit"
        );

        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in)
        );

        while (isActive) {
            switch(in.readLine()) {
                case "a": {
                    System.out.println("Random Demogorgon:");
                    randDemogorgonGen();
                    break;
                } case "b": {
                    System.out.println("Default Demogorgon:");
                    defaultDemogorgonGen();
                    break;
                } case "c": {
                    System.out.println("Exiting...");
                    isActive = false;
                    break;
                } default: {
                    System.out.println("Please enter a valid answer");
                }
            }
        }
    }

    public static void defaultDemogorgonGen() {
        Demogorgon defaultDemogorgon = new Demogorgon();
        displayDemogorgon(defaultDemogorgon);
    }

    public static void randDemogorgonGen() {
        int randCountFlyTrapFlaps = (int) Math.floor(Math.random() * 1000);
        boolean isElbowStabber = Math.random() > .5;
        double randClawsLength = Math.random() * 30;
        double size = Math.random();
        ArrayList powers = generateRandPowers();
        Demogorgon randomDemogorgon = new Demogorgon(randCountFlyTrapFlaps, randClawsLength, isElbowStabber, powers, size);
        displayDemogorgon(randomDemogorgon);
    }

    public static ArrayList generateRandPowers() {
        int powerCount = (int) Math.ceil(Math.random() * 4);
        ArrayList<String> defaultPowers = new ArrayList(Arrays.asList("jump", "hop", "skip", "eat", "dance", "celebrate"));
        ArrayList<String> randomPowers = new ArrayList<>();

        while (powerCount > 0) {
            int powerPicker = (int) Math.floor(Math.random() * defaultPowers.size());
            String pickedPower = defaultPowers.get(powerPicker);
            randomPowers.add(pickedPower);
            defaultPowers.remove(powerPicker);
            powerCount -= 1;
        }

        return randomPowers;
    }

    public static void displayDemogorgon(Demogorgon demogorgon) {
        System.out.println(demogorgon.toString());
    }
}