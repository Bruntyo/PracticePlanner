package controller;

import model.Plan;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;

public class CreatePlanController {



    MainController mainController = MainController.getInstance();
    PlanController planController = PlanController.getInstance();

    public static CreatePlanController instance;

    public static CreatePlanController getInstance(){
        if(instance == null){
            instance = new CreatePlanController();
        }
        return instance;
    }

    private CreatePlanController(){
    }

    public void createAndAddPlan(Plan plan){
        planController.setActivePlan(plan);
        planController.setAllProperties(plan);
        mainController.addPlan(plan);
    }
}
