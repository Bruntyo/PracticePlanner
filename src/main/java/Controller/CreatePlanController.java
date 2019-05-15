package controller;

import model.Plan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to handle creation of new plans
 */
public class CreatePlanController {

    public static final Logger logger = LoggerFactory.getLogger(CreatePlanController.class);

    MainController mainController = MainController.getInstance();
    PlanController planController = PlanController.getInstance();

    public static CreatePlanController instance;

    public static CreatePlanController getInstance(){
        if(instance == null){
            instance = new CreatePlanController();
        }
        return instance;
    }

    /**
     * Creates a new plan and adds it to the main list of plans
     * @param plan
     */
    public void createAndAddPlan(Plan plan){
        logger.info("Adding new plan");
        planController.setActivePlan(plan);
        planController.setAllProperties(plan);
        mainController.addPlan(plan);
    }
}
