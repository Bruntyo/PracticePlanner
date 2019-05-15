package model;

import myUtils.myIdGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;

public class Activity {

    int id;
    String name;
    String description;
    boolean complete;
    int hoursToComplete;
    int hoursCompleted;
    int refreshFrequency;
    LocalDate dueDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getComplete(){
        return complete;
    }

    public int getHoursToComplete() {
        return hoursToComplete;
    }

    public int getHoursCompleted() {
        return hoursCompleted;
    }

    public int getRefreshFrequency() {
        return refreshFrequency;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setHoursToComplete(int hoursToComplete) {
        this.hoursToComplete = hoursToComplete;
    }

    public void setHoursCompleted(int hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

    public void setRefreshFrequency(int refreshFrequency) {
        this.refreshFrequency = refreshFrequency;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Activity(String name, String description, int hoursToComplete, int refreshFrequency){
        this.id = myIdGenerator.getNextId();
        this.name = name;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
        this.refreshFrequency = refreshFrequency;
        this.dueDate = null;
    }

    public Activity(String name, String description, int hoursToComplete, int refreshFrequency, LocalDate dueDate){
        this.id = myIdGenerator.getNextId();
        this.name = name;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
        this.refreshFrequency = refreshFrequency;
        this.dueDate = dueDate;
    }

    public  Activity(){}

}
