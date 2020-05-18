package com.buildui.ui;

import com.buildui.util.StageBuilder;
import com.buildui.util.StageName;

public class StageController {
    private StageBuilder sb = new StageBuilder();

    public void setNewStage(StageName stage)
    {
        if (sb.getStage() != null)
            this.closeStage();

        switch(stage) {
            case LOG_IN:
                this.buildLogin();
                break;
            case SIGN_UP:
                this.buildSignup();
                break;
            case LOADING:
                break;
            case DASHBOARD:
                this.buildDashboard();
                break;
            case SETTINGS:
                break;
            case NEW_PROJECT:
                break;
            case CHAT:
                break;
        }
    }

    private void buildLogin() {
        sb.buildStage("/fxml/login.fxml", 560, 480, false);
    }

    private void buildSignup() {
        sb.buildStage("/fxml/signup.fxml", 650, 700, false);
    }

    private void buildDashboard() {
        sb.buildStage( "/fxml/dashboard.fxml", 1000, 800, true);
    }

    public void closeStage() {
        sb.closeStage();
    }
}
