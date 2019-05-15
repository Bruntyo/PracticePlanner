package controller;

import javafx.fxml.Initializable;
import model.Activity;
import model.Plan;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ActivityController implements Initializable {

    private static ActivityController instance;

    public static ActivityController getInstance(){
        if(instance == null)
            instance = new ActivityController();
        return instance;
    }

    Activity activeActivity;
    public void setActiveActivity(Activity activeActivity) {
        this.activeActivity = activeActivity;
    }

    public Activity getActiveActivity(){return activeActivity;}

    private ActivityController(){

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
