package controller;

import javafx.fxml.Initializable;
import model.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class for handling activity activation
 */
public class ActivityController implements Initializable {

    /**
     * Singleton controller instance
     */
    private static ActivityController instance;
    public static final Logger logger = LoggerFactory.getLogger(ActivityController.class);


    /**
     * Gets the singleton instance
     * @return instance
     */
    public static ActivityController getInstance(){
        if(instance == null)
            instance = new ActivityController();
        return instance;
    }

    Activity activeActivity;

    /**
     * Sets active activity to handle setting up multiple activities
     * @param activeActivity The activity that is currenctly selected
     */
    public void setActiveActivity(Activity activeActivity) {
        this.activeActivity = activeActivity;
    }

    /**
     * Gets active activity to handle setting up multiple activities
     * @return activeActivity The activity that is currenctly selected
     */
    public Activity getActiveActivity(){return activeActivity;}

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("Initializing " + this.getClass().getSimpleName());
    }
}
