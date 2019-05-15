package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a User model
 */
public class User {

    String name;

    String favoriteActivityName;

    List<Plan> planList;

    /**
     * gets the name of the current User
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the current User
     * @param name name to be given
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * loads set list of plans for the current User
     * @param plans plans to be loaded
     */
    public void loadPlans(List<Plan> plans){
        planList = plans;
    }

    /**
     * gets the plans associated with the current User
     * @return plans
     */
    public List<Plan> getPlans(){
        return planList;
    }

    /**
     * gets the name of the favorite activity of the current User
     * @return String name
     */
    public String getFavoriteActivityName(){
        int max = 0;
        for (Plan plan : planList) {
            for(Activity activity : plan.getActivities()){
                if (activity.getHoursCompleted() > max)
                    favoriteActivityName = activity.getName();
            }
        }
        return favoriteActivityName;
    }

    /**
     * sets the name of the favorite activity of the current User
     * @param name
     */
    public void setFavoriteActivityName(String name){
        favoriteActivityName = name;
    }

    /**
     * Constructor for the User class
     * @param name name to be given
     */
    public User(String name){
        this.name = name;
        planList = new ArrayList<>();
    }

    /**
     * Constructor to create instance from UserData object
     * @param userData object to take parameters from
     */
    public User(UserData userData){
        this.name = userData.name;
        this.setFavoriteActivityName(userData.favoriteActivityName);
        planList = new ArrayList<>();
    }

}
