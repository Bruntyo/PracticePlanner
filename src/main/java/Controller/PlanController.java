package controller;

import model.Activity;
import model.Goal;
import model.Plan;
import model.User;

import java.util.List;

public class PlanController {

    private static PlanController instance;

    public static PlanController getInstance(){
        if(instance == null)
            instance = new PlanController();
        return instance;
    }

    Plan activePlan;

    public void setActivePlan(Plan activePlan) {
        this.activePlan = activePlan;
    }

    public String getName(){
        return getActivePlan().getName();
    }

    public Plan getActivePlan() {
        return activePlan;
    }

    public int getTimeGoal() {
        return getActivePlan().getTimeGoal();
    }

    public int getMinutesSpent() {return getActivePlan().getMinutesSpent();}

    public void setName(String name){
        getActivePlan().setName(name);
    }

    public void calculateTotalTimeSpent(){
        getActivePlan().setMinutesSpent(0);
        for (Activity activity: getActivePlan().getActivities()) {
            getActivePlan().setMinutesSpent(getActivePlan().getMinutesSpent() + activity.getHoursCompleted());
        }
    }


    public void setAllProperties(Plan plan){
        getActivePlan().setName(plan.getName());
        getActivePlan().setDescription(plan.getDescription());
        getActivePlan().setOwner(plan.getOwner());
        getActivePlan().setTimeGoal(plan.getTimeGoal());
        getActivePlan().setMinutesSpent(0);
        getActivePlan().setCompleted(plan.getCompleted());
        getActivePlan().setGoals(plan.getGoals());
        getActivePlan().setActivities(plan.getActivities());
    }






    private PlanController(){

    }
}
