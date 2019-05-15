package model;

/**
 * Class to represent a UserData model
 */
public class UserData {

    String name;

    String favoriteActivityName;

    /**
     * Constructor for the class
     * @param name name to be given
     * @param favoriteActivityName favorite activity name to be given
     */
    public UserData(String name, String favoriteActivityName){
        this.name = name;
        this.favoriteActivityName = favoriteActivityName;
    }
}
