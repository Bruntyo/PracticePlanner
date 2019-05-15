package controller;

import com.google.gson.Gson;
import model.User;
import model.UserData;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle starting the application and User related operations
 */
public class StartController {

    public static StartController instance;
    private final String UserFile = "userData/user.json";
    private File file = new File(UserFile);

    public static StartController getInstance() {
        if(instance == null)
            instance = new StartController();
        return instance;
    }

    /**
     * User instance
     */
    User user;

    /**
     * data to be inserted into database
     */
    List<String> data = new ArrayList<>();

    /**
     * Loads User from database
     * @return User loaded from database
     */
    public User loadUser(){
        UserData userData;
        String jsonData;
        if(file.exists()) {
            Gson gson = new Gson();
            try {
                 jsonData = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            } catch (Exception e) {jsonData = "Could not read";}
             userData = gson.fromJson(jsonData, UserData.class);
            user = new User(userData);
        }
        else {
            createUser();
        }
        return user;
    }

    /**
     * Creates new User and writes it into database file
     */
    public void createUser(){
        user = new User("New User");
        UserData userData = new UserData(user.getName(),user.getFavoriteActivityName());

        Gson gson = new Gson();
        String data = gson.toJson(userData);
        try {
            FileUtils.writeStringToFile(file, data, StandardCharsets.UTF_8, false);
        } catch (Exception e) {}
    }

    /**
     * Saves given user into database file
     * @param user User to be saved
     */
    public void saveUser(User user){
        UserData userData = new UserData(user.getName(),user.getFavoriteActivityName());
        File file = new File(UserFile);

        Gson gson = new Gson();
        String data = gson.toJson(userData);
        try {
            FileUtils.writeStringToFile(file, data, StandardCharsets.UTF_8, false);
        } catch (Exception e) {}
    }

    /**
     * Gets user instance of class
     * @return User
     */
    public User getUser(){
        return user;
    }

    //Create Profile

    //Initialize
}
