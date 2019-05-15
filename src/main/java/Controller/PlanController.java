package controller;

import model.Activity;
import model.Goal;
import model.Plan;
import model.User;

import java.util.List;

/**
 * Class to handle plan related interactions
 */
public class PlanController {

    private static PlanController instance;

    public static PlanController getInstance(){
        if(instance == null)
            instance = new PlanController();
        return instance;
    }

    /**
     * Instance of the currently selected plan
     */
    Plan activePlan;

    /**
     * Sets the currently selected plan for future operations
     * @param activePlan the plan to be selected
     */
    public void setActivePlan(Plan activePlan) {
        this.activePlan = activePlan;
    }

    /**
     * Gets the name of the currently active plan
     * @return name of the currently active plan
     */
    public String getName(){
        return getActivePlan().getName();
    }

    /**
     * Gets the currently active plan
     * @return the currently selected plan
     */
    public Plan getActivePlan() {
        return activePlan;
    }

    /**
     * Gets the time goal for the currently active plan
     * @return time goal of the plan
     */
    public int getTimeGoal() {
        return getActivePlan().getTimeGoal();
    }

    /**
     * Gets total minutes spent doing currently active plan
     * @return minutes spent with activity
     */
    public int getMinutesSpent() {return getActivePlan().getMinutesSpent();}

    /**
     * Sets the name of the active plan
     * @param name name of the active plan
     */
    public void setName(String name){
        getActivePlan().setName(name);
    }

    /**
     * Calculates total time spent doing current plan,
     * by adding all the time spent with each individual activity
     */
    public void calculateTotalTimeSpent(){
        getActivePlan().setMinutesSpent(0);
        for (Activity activity: getActivePlan().getActivities()) {
            getActivePlan().setMinutesSpent(getActivePlan().getMinutesSpent() + activity.getHoursCompleted());
        }
    }


    /**
     * Sets all relevant properties for the currently active plan
     * @param plan object to copy
     */
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
