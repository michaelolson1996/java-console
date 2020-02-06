package edu.neumont.csc150.c.shapes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeController implements Runnable {
    private ShapeView view = new ShapeView();
    private List<Shape> model = new ArrayList<>();

    public void run() {
        try {
            boolean exitRequested = false;
            do {
                view.displayMainMenu();
                int selection = view.getIntegerFromUser(0, 4);
                switch (selection) {
                    case 0:
                        exitRequested = true;
                        break;
                    case 1:
                        onAddSquare();
                        break;
                    case 2:
                        onAddCircle();
                        break;
                    case 3:
                        onPrintShapes();
                        break;
                    case 4:
                        onAddRightTriangle();
                        break;
                    default:
                        throw new RuntimeException("Invalid User Selection " + selection);
                }
            } while (!exitRequested);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void onAddSquare() throws IOException {
        view.showMessage("Enter side length (1 - 100)");
        double sideLength = view.getDoubleFromUser(1, 100);
        Square s = new Square(sideLength);
        this.model.add(s);
    }

    private void onAddCircle() throws IOException {
        view.showMessage("Enter radius (1 - 100)");
        double radius = view.getDoubleFromUser(1, 100);
        Circle c = new Circle(radius);
        this.model.add(c);
    }

    private void onAddRightTriangle() throws IOException {
        view.showMessage("Enter Base (1 - 100)");
        double base = view.getDoubleFromUser(1, 100);
        view.showMessage("Enter Height");
        double height = view.getDoubleFromUser(1, 100);
        RightTriangle t = new RightTriangle(base, height);
        this.model.add(t);
    }

    private void onPrintShapes() {
        for (Shape s : this.model) {
            view.showMessage(
                    String.format("%s Area = %f Perimiter = %f",
                            s.toString(), s.getArea(), s.getPerimeter())
            );
        }
    }
}
