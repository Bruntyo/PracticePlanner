package model;

import java.time.LocalDate;

/**
 * Class to represent an Activity model
 */
public class Activity {

    String name;
    String description;
    boolean complete;
    int hoursToComplete;
    int hoursCompleted;

    /**
     * Gets name of the activity
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets hours required to complete the activity
     * @return hours to complete
     */
    public int getHoursToComplete() {
        return hoursToComplete;
    }

    /**
     * gets hours already spent doing the activity
     * @return hours spent
     */
    public int getHoursCompleted() {
        return hoursCompleted;
    }

    /**
     * sets the name of the activity
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the description of the activity
     * @param description description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets complete property of activity
     * @param complete wether or not the activity has been completed
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * Sets hours required to complete the activity
     * @param hoursToComplete hours required
     */
    public void setHoursToComplete(int hoursToComplete) {
        this.hoursToComplete = hoursToComplete;
    }

    /**
     * sets hours already spent doing the activity
     * @param hoursCompleted
     */
    public void setHoursCompleted(int hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

    /**
     * Constructor of the Activity class
     * @param name name of the activity
     * @param description description of the activity
     * @param hoursToComplete hours rewuired to complete the activity
     */
    public Activity(String name, String description, int hoursToComplete){
        this.name = name;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
    }

    /**
     * Empty constructor for easier calls
     */
    public  Activity(){}

}
