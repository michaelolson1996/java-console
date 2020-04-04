package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private int counter = 0;

    @FXML
    private TextField myTextField;

    @FXML
    private Label statusLabel;

    public void onButtonClick(ActionEvent actionEvent) {
        counter++;
        myTextField.setText("" + counter);
        statusLabel.setText("" + counter);
    }

    public void onExitClick(ActionEvent actionEvent) {
        System.exit(0);
    }
}
