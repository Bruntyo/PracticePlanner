package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a Plan model
 */
public class Plan {

    int id;

    String name;

    String description;

    List<Goal> goals;

    List<Activity> activities;

    User owner;

    int timeGoal;

    int minutesSpent;

    boolean completed;

    /**
     * gets the ID of the plan
     * @return int Id
     */
    public int getId() {
        return id;
    }

    /**
     * gets the name of the plan
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the description of the plan
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets owner of the plan
     * @return User owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Get number of hours required to complete the plan
     * @return int hours
     */
    public int getTimeGoal() {
        return timeGoal;
    }

    /**
     * gets the minutes spent on the plan
     * @return int minutes
     */
    public int getMinutesSpent() {return minutesSpent;}

    /**
     * gets completion status of the plan
     * @return boolean completed
     */
    public boolean getCompleted(){
        return  completed;
    }

    /**
     * gets the goals of the plan
     * @return List goals
     */
    public List<Goal> getGoals() {
        return goals;
    }

    /**
     * gets the activities associated with the plan
     * @return List activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * sets the name of the plan
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the description of the plan
     * @param description String description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets the owner of the plan
     * @param owner User to be set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * sets the time required to complete the plan
     * @param timeGoal int minutes
     */
    public void setTimeGoal(int timeGoal) {
        this.timeGoal = timeGoal;
    }

    /**
     * sets the minutes spent doing the activities of the plan
     * @param minutesSpent int minutes
     */
    public void setMinutesSpent(int minutesSpent) {this.minutesSpent = minutesSpent;}

    /**
     * sets the completion status of the plan
     * @param completed boolean status
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * sets the goals associated with the plan
     * @param goals List goals
     */
    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    /**
     * adds a single goal to the plan
     * @param goal goal to be added
     */
    public void addGoal(Goal goal) {goals.add(goal);}

    /**
     * removes a single goal from the plan
     * @param goal goal to be removed
     */
    public void removeGoal(Goal goal) {goals.remove(goal);}

    /**
     * sets activities list for the plan
     * @param activities activities to set for the plan
     */
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    /**
     * adds a single activity to the plan
     * @param activity activity to be added
     */
    public void addActivity(Activity activity) {activities.add(activity);}

    /**
     * removes a single activity from the plan
     * @param activity activity to be removed
     */
    public void removeActivity (Activity activity) {activities.remove(activity);}

    /**
     * Constructor of the Plan class
     * @param name name to be given
     * @param description description to be given
     * @param owner owner to be given
     */
    public Plan(String name, String description, User owner){
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    /**
     * Empty constructor for the plan class for easy testing
     */
    public Plan(){
        activities = new ArrayList<>();
    }
}
