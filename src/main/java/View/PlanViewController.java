package view;

import controller.ActivityController;
import controller.PlanController;
import controller.StartController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Activity;
import model.Goal;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.StrictMath.abs;

public class PlanViewController implements Initializable {


    private PlanController planController = PlanController.getInstance();
    private ActivityController activityController = ActivityController.getInstance();

    @FXML
    Label planName;
    @FXML
    Button backButton;
    @FXML
    Label profileName;
    @FXML
    Pane goalsPane;
    @FXML
    TextFlow descriptionTextFlow;
    @FXML
    Text descriptionText;
    @FXML
    GridPane activitiesGridPane;
    @FXML
    Button addNewActivityButton;
    @FXML
    Rectangle progressFront;
    @FXML
    Rectangle progressBack;
    @FXML
    Label progressBarLabel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refresh();

    }

    public void handleBackAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/mainScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the main page!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleAddNewActivityAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/createActivityScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the activity creation page!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void refresh(){

        profileName.setText("Welcome User");
        planName.setText(planController.getActivePlan().getName());
        descriptionText.setText(planController.getActivePlan().getDescription());
        planController.calculateTotalTimeSpent();
        calculateProgress();
        fillGridPane();
        if(activitiesGridPane.getChildren().size()>5)
            addNewActivityButton.setDisable(true);


    }


    private void fillGridPane(){
        int i = 0;
        Button button;
        for (Activity activity : planController.getActivePlan().getActivities()) {
            button = new Button(activity.getName());
            button.setOnAction((event) -> {
                try{handleActivityClicked(activity);}catch (Exception e) {System.out.println(e.getMessage());}
            });
            activitiesGridPane.add(button,
                    abs(activitiesGridPane.getColumnConstraints().size() + ((i%3) - activitiesGridPane.getColumnConstraints().size())),
                    abs(activitiesGridPane.getRowConstraints().size() + (getYCoord(i) - activitiesGridPane.getColumnConstraints().size())));
            i = activitiesGridPane.getChildren().size();
            button.setPrefWidth(50);
            button.setPrefWidth(100);
            button.setPadding(new Insets(5,5,5,5));
        }
    }

    private void handleActivityClicked(Activity activity) throws IOException{
        System.out.println("Button clicked: " + activity.getName());
        activityController.setActiveActivity(activity);

        Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/activityScene.fxml"));
            stage.setTitle("activity scene");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void calculateProgress(){
        progressFront.setWidth(progressBack.getWidth()*
                ((double) planController.getActivePlan().getMinutesSpent()
                        /(double)(planController.getActivePlan().getTimeGoal())));
        progressBarLabel.setText("" + planController.getMinutesSpent() + "/" + planController.getTimeGoal());
        if(progressFront.getWidth() >= progressBack.getWidth()) {
            progressFront.setWidth(progressBack.getWidth());
            progressFront.setFill(Paint.valueOf("Goldenrod"));
        }
    }

    private int getYCoord(int i){
        if(i<=2)
            return 0;
        else
            return 1;
    }


    //TODO SET ALL VALUES
}
