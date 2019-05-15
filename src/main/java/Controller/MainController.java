package controller;

import javafx.fxml.Initializable;
import model.Plan;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static MainController instance;
    List<Plan> plans;


    public static MainController getInstance(){
        if(instance == null)
            instance = new MainController();
        return instance;
    }

    private MainController(){
        plans = new ArrayList<>();
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public Plan addPlan(Plan plan){
        plans.add(plan);
        return plan;
    }

    public Plan removePlan(Plan plan){
        plans.remove(plan);
        return plan;
    }

    public void purgePlans(){
        plans.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
