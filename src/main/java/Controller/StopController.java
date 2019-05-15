package controller;

import com.google.gson.Gson;
import javafx.application.Platform;
import model.User;
import model.UserData;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * Class to handle stopping the application
 */
public class StopController {

    private final String UserFile = "userData/user.json";

    /**
     * Saves current user to database file and stops the application
     * Is called the Exit button, as well as the standard ending of the application
     * @param user User to save
     */
    public StopController(User user){
        saveUser(user);
        stop();
    }

    /**
     * Handles saving given user to database file
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
     * Calls exit method of the application
     */
    public void stop(){
        Platform.exit();
    }
}
