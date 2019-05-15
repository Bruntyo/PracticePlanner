package view;

import controller.MainController;
import controller.PlanController;
import controller.StartController;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import model.Plan;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    int i=0; // TODO REMOVE
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

    StartController startController = new StartController();
    MainController mainController = MainController.getInstance();
    PlanController planController = PlanController.getInstance();


    public void handleExitAction(){
        Platform.exit();
    }

    public void handlePlanClicked(Plan plan) {
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
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/createPlanScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the plan creation page!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profileName.setText(startController.loadUser());
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

}
