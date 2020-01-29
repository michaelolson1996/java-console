package neumont.csc150.c.zombie;

import java.io.IOException;

public class ZombieCreator {

    ZombieCreatorUI ui = new ZombieCreatorUI();

    private void exec() throws IOException {
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
                        break;
                }
            } catch (Exception err) {
                ui.displayPrompt("Your answer is not supported, please enter a new answer");
            }

        }
    }

    private void generateSingleZombie() {

    }

    private void generateRandZombies() {

    }

    private void generateNZombies() {

    }

    public static void main(String[] args) throws IOException {
        ZombieCreator zc = new ZombieCreator();
        zc.exec();
    }
}
