package view;

import controller.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import model.Plan;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    public static final Logger logger = LoggerFactory.getLogger(MainViewController.class);

    @FXML
    Button setNameButton;
    @FXML
    TextField enterNameField;
    @FXML
    VBox vBox;
    @FXML
    AnchorPane anchor;
    @FXML
    ScrollPane scroll;
    @FXML
    Button exitButton;
    @FXML
    Button createNewPlanButton;
    @FXML
    Label profileName;

    StartController startController = StartController.getInstance();
    MainController mainController = MainController.getInstance();
    PlanController planController = PlanController.getInstance();
    StopController stopController;
    User user = startController.loadUser();


    public void handleExitAction(){
        stopController = new StopController(user);
    }

    public void handlePlanClicked(Plan plan) {
        logger.info("Stepping into Plan Scene");
        System.out.println("Button clicked: " + plan.getName());
        planController.setActivePlan(plan);

        Stage stage = (Stage) exitButton.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/planScene.fxml"));
            stage.setTitle("plan scene");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void handleCreateNewPlan(ActionEvent actionEvent) throws IOException {
        logger.info("Creating plan and Stepping into Plan Creation Scene");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/createPlanScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the plan creation page!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        user = startController.getUser();
        user.loadPlans(mainController.getPlans());
        if(user.getFavoriteActivityName() != null)
            profileName.setText("Welcome " + user.getName() + "! Your Favorite Activity was: " + user.getFavoriteActivityName());
        else
            profileName.setText("Welcome " + user.getName());
        purgePlans();
        fillWithPlans();
    }

    public void fillWithPlans() {
        Button button;
        for (Plan plan: mainController.getPlans()) {
            button = new Button();
            vBox.getChildren().add(vBox.getChildren().size(),button);
            button.setText(plan.getName());
            button.setPrefHeight(70);
            button.setMaxHeight(70);
            button.setPrefWidth(707);
            button.setMaxWidth(707);
            button.setPadding(new Insets(10, 10, 10, 10));
            button.setOnAction((event) -> {
                try{handlePlanClicked(plan);}catch (Exception e) {System.out.println(e.getMessage());}
            });
        }
    }

    public void purgePlans(){
        vBox.getChildren().clear();
    }

    public void handleSetNameAction() {
        enterNameField.setDisable(false);
        enterNameField.setVisible(true);
    }

    public void handleEnterNameAction() {
        user.setName(enterNameField.getText());
        profileName.setText("Welcome " + user.getName() + "! Your Favorite Activity is: " + user.getFavoriteActivityName());
        enterNameField.setDisable(true);
        enterNameField.setVisible(false);
    }
}
