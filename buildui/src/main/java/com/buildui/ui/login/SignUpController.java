package com.buildui.ui.login;

import com.buildui.ui.StageController;
import com.buildui.util.StageName;
import javafx.fxml.FXML;

public class SignUpController extends StageController {





    @FXML
    private void handleSignUpSubmitAction() {
        this.setNewStage(StageName.LOG_IN);
    }
}
