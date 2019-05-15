package view;

import controller.ActivityController;
import controller.PlanController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityViewController implements Initializable {


    @FXML
    public AnchorPane anchorPane;

    @FXML
    public Label profileName;

    @FXML
    public Button backButton;

    @FXML
    public Label nameLabel;

    @FXML
    public Text descriptionLabel;

    @FXML
    public Arc progressArc;

    @FXML
    public Label progressLabel;

    @FXML
    public Button completeButton;

    @FXML
    public Button changeHoursToCompleteButton;

    @FXML
    public Button changeHoursCompletedButton;

    @FXML
    public Label hoursToComplete;

    @FXML
    public Label hoursCompleted;

    @FXML
    public TextField hiddenToComplete;

    @FXML
    public TextField hiddenCompleted;

    ActivityController activityController = ActivityController.getInstance();
    int changeToComplete;
    int changeCompleted;

    public void handleBackAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/planScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the main page!");
        Scene scene = new Scene(root);
        anchorPane.getChildren().clear();
        stage.setScene(scene);
        stage.show();
    }

    public void handleChangeHoursToCompleteAction(ActionEvent actionEvent) {
        hiddenToComplete.setVisible(true);
        hiddenToComplete.setDisable(false);
    }

    public void handleChangeHoursCompletedAction(ActionEvent actionEvent) {
        hiddenCompleted.setVisible(true);
        hiddenCompleted.setDisable(false);
    }

    public void handleToCompleteEnterAction(ActionEvent actionEvent) {
        changeToComplete = Integer.parseInt(hiddenToComplete.getText());
        activityController.getActiveActivity().setHoursToComplete(changeToComplete);
        hiddenToComplete.setVisible(false);
        hiddenToComplete.setDisable(true);
        setProgressArc();
        hoursCompleted.setText("" + activityController.getActiveActivity().getHoursCompleted());
        hoursToComplete.setText("" + activityController.getActiveActivity().getHoursToComplete());
    }

    public void handleCompleteEnterAction(ActionEvent actionEvent) {
        changeCompleted = Integer.parseInt(hiddenCompleted.getText());
        activityController.getActiveActivity().setHoursCompleted(changeCompleted);
        hiddenCompleted.setVisible(false);
        hiddenCompleted.setDisable(true);
        setProgressArc();
        hoursCompleted.setText("" + activityController.getActiveActivity().getHoursCompleted());
        hoursToComplete.setText("" + activityController.getActiveActivity().getHoursToComplete());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText(activityController.getActiveActivity().getName());
        descriptionLabel.setText(activityController.getActiveActivity().getDescription());
        hoursCompleted.setText("" + activityController.getActiveActivity().getHoursCompleted());
        hoursToComplete.setText("" + activityController.getActiveActivity().getHoursToComplete());
    }

    private void setProgressArc(){
        progressArc.setLength(360*
                (((double)activityController.getActiveActivity().getHoursCompleted())/
                        ((double)activityController.getActiveActivity().getHoursToComplete())));
    }
}
