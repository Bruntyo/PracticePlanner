package model;

/**
 * Class to represent set goals that can be given to a plan or activity
 * Not Yet implemented into main application
 */
public class Goal {

    String name;
    String description;
    boolean complete;

    /**
     * Gets the name of the goal
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the description of the goal
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets the completion status of the goal
     * @return boolean completion status
     */
    public boolean getComplete(){
        return complete;
    }

    /**
     * sets the name of the goal
     * @param name name to be given
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the description of the goal
     * @param description description to be given
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets completion status of the goal
     * @param complete completion status
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * Constructor of the goal class
     * @param name name of the goal
     * @param description description of the goal
     */
    public Goal(String name, String description){
        this.name = name;
        this.description = description;
        this.complete = false;
    }

    /**
     * Empty constructor for easier building
     */
    public Goal(){}
}
