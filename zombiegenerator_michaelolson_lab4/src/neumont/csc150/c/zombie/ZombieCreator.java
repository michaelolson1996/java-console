package neumont.csc150.c.zombie;

import neumont.csc150.c.zombie.model.ZedGenerator;

import java.io.IOException;

public class ZombieCreator {

    ZombieCreatorUI ui = new ZombieCreatorUI();
    ZedGenerator zg = new ZedGenerator();

    private void exec() {
        boolean userRequestedExit = false;

        while (!userRequestedExit) {
            ui.displayMenu();
            try {
                int userChoice = Integer.parseInt(ui.getStringInput());
                switch(userChoice) {
                    case 0:
                        ui.displayPrompt("Exiting...");
                        userRequestedExit = true;
                        break;
                    case 1:
                        generateSingleZombie();
                        break;
                    case 2:
                        generateRandZombies();
                        break;
                    case 3:
                        generateNZombies();
                        break;
                    default:
                        ui.displayPrompt("That answer is not supported");
                        break;
                }
                zg.clearHorde();
            } catch (Exception err) {
                System.out.println(err.toString());
                ui.displayPrompt("Your answer is not supported, please enter a new answer");
            }
        }
    }

    private void generateSingleZombie() {
        zg.generateOneZombie();
        ui.displayPrompt(zg.displayHorde());
    }

    private void generateRandZombies() {
        zg.generateSomeZombies();
        ui.displayPrompt(zg.displayHorde());
    }

    private void generateNZombies() throws IOException {
        ui.displayPrompt("How many zombies would you like to add?");
        String zombieCount = ui.getStringInput();
        zg.generateNZombies(Integer.parseInt(zombieCount));
        ui.displayPrompt(zg.displayHorde());
    }

    public static void main(String[] args) {
        ZombieCreator zc = new ZombieCreator();
        zc.exec();
    }
}
