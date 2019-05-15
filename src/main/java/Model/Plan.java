package model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.util.List;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User getOwner() {
        return owner;
    }

    public int getTimeGoal() {
        return timeGoal;
    }

    public int getMinutesSpent() {return minutesSpent;}

    public boolean getCompleted(){
        return  completed;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setTimeGoal(int timeGoal) {
        this.timeGoal = timeGoal;
    }

    public void setMinutesSpent(int minutesSpent) {this.minutesSpent = minutesSpent;}

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public void addGoal(Goal goal) {goals.add(goal);}

    public void removeGoal(Goal goal) {goals.remove(goal);}

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {activities.add(activity);}

    public void removeActivity (Activity activity) {activities.remove(activity);}

    public Plan(String name, String description, User owner){
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public Plan(){}
}
