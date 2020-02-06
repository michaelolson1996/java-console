package edu.neumont.csc150.c.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterstateController {
    private InterstateView view = new InterstateView();
    private List<Vehicle> vehicles = new ArrayList<>();

    public void run() {
        this.vehicles.add(new Jeep(0));
        this.vehicles.add(new Ferrari(0));
        try {
            boolean exitRequested = false;

            do {
                view.displayMainMenu();
                int selection = view.getInputFromUser();
                switch(selection) {
                    case 0:
                        exitRequested = true;
                        break;
                    case 1:
                        onAccelerate();
                        break;
                    case 2:
                        onBrake();
                        break;
                    default:
                        throw new RuntimeException("Invalid User Selection" + selection);
                }
            } while(!exitRequested);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void onAccelerate() {
        view.showMessage("Vroooooom");
        for (Vehicle v : this.vehicles) {
            v.accelerate();
        }
        view.showVehicleStatus(this.vehicles);
    }

    private void onBrake() {
        view.showMessage("Screeeeeeech");
        for (Vehicle v : this.vehicles) {
            v.brake();
        }
        view.showVehicleStatus(this.vehicles);
    }
}
