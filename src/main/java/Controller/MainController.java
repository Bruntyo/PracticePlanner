package controller;

import javafx.fxml.Initializable;
import model.Plan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class to handle the plan list and main window operations
 */
public class MainController implements Initializable {

    StartController startController = StartController.getInstance();
    public static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    private static MainController instance;
    List<Plan> plans;


    public static MainController getInstance(){
        if(instance == null)
            instance = new MainController();
        return instance;
    }

    /**
     * Private constructor ensures plans don't get deleted by mistake
     */
    private MainController(){
        if(null == startController.getUser())
            plans = new ArrayList<>();
        else
            plans = startController.getUser().getPlans();
    }

    /**
     * Gets all currently available plans
     * @return every plan created since the start of the application
     */
    public List<Plan> getPlans() {
        return plans;
    }

    /**
     * Adds new plan to the plan list
     * @param plan plan to be added
     * @return plan added
     */
    public Plan addPlan(Plan plan){
        plans.add(plan);
        return plan;
    }


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
