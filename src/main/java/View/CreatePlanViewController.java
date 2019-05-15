package view;

import controller.ActivityController;
import controller.CreatePlanController;
import controller.StartController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Activity;
import model.Goal;
import model.Plan;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatePlanViewController {

    public static final Logger logger = LoggerFactory.getLogger(CreatePlanViewController.class);

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Label profileName;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextArea descriptionTextField;
    @FXML
    public ToggleButton dueByToggleButton;
    @FXML
    public DatePicker datePicker;
    @FXML
    public Pane hiddenPane;
    @FXML
    public TextArea hiddenDescriptionField;
    @FXML
    public TextField hiddenNameField;
    @FXML
    public Button hiddenAddButton;
    @FXML
    public Button hiddenCancelButton;
    @FXML
    public Button addGoalButton;
    @FXML
    public TextField hoursTextField;
    @FXML
    public Button doneButton;
    @FXML
    public Button backButton;

    Plan planToCreate = new Plan();
    List<Goal> goalList = new ArrayList<>();
    List<Activity> activityList = new ArrayList<>();

    CreatePlanController createPlanController = CreatePlanController.getInstance();
    StartController startController = StartController.getInstance();

    public void handleHiddenAddAction() {

        Goal goal = new Goal();
        goal.setName(hiddenNameField.getText());
        goal.setDescription(hiddenDescriptionField.getText());
        goal.setComplete(false);
        goalList.add(goal);


        hiddenPane.setVisible(false);
        hiddenPane.setDisable(true);
        for (Node node: hiddenPane.getChildren()) {
            node.setDisable(true);
            node.setVisible(false);
        }

        hiddenDescriptionField.clear();
        hiddenNameField.clear();
    }

    public void handleHiddenCancelAction() {
        anchorPane.setDisable(false);

        hiddenPane.setVisible(false);
        hiddenPane.setDisable(true);
        for (Node node: hiddenPane.getChildren()) {
            node.setDisable(true);
            node.setVisible(false);
        }

        hiddenDescriptionField.clear();
        hiddenNameField.clear();
    }

    public void handleCreatePlanAction(ActionEvent actionEvent) throws IOException {
        logger.info("Creating plan and Stepping into Main Scene");
        planToCreate.setName(nameTextField.getText());
        planToCreate.setDescription(descriptionTextField.getText());
        planToCreate.setCompleted(false);
        planToCreate.setOwner(new User("Test"));
        planToCreate.setGoals(goalList);
        planToCreate.setActivities(activityList);
        planToCreate.setTimeGoal(Integer.parseInt(hoursTextField.getText())*60);
        createPlanController.createAndAddPlan(planToCreate);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/mainScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the main page!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleBackAction(ActionEvent actionEvent) throws IOException {
        logger.info("Stepping into Main Scene");
        startController.saveUser(startController.getUser());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/mainScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the main page!");
        Scene scene = new Scene(root);
        anchorPane.getChildren().clear();
        stage.setScene(scene);
        stage.show();
    }
}
