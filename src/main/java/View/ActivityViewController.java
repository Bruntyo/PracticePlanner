package view;

import controller.ActivityController;
import controller.StartController;
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
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityViewController implements Initializable {

    public static final Logger logger = LoggerFactory.getLogger(ActivityViewController.class);

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
    StartController startController = StartController.getInstance();
    int changeToComplete;
    int changeCompleted;
    User user;

    public void handleBackAction(ActionEvent actionEvent) throws IOException {
        logger.info("Stepping into plan Scene");
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
        setProgressArc(progressArc);
        hoursCompleted.setText("" + activityController.getActiveActivity().getHoursCompleted());
        hoursToComplete.setText("" + activityController.getActiveActivity().getHoursToComplete());
    }

    public void handleCompleteEnterAction(ActionEvent actionEvent) {
        changeCompleted = Integer.parseInt(hiddenCompleted.getText());
        activityController.getActiveActivity().setHoursCompleted(changeCompleted);
        hiddenCompleted.setVisible(false);
        hiddenCompleted.setDisable(true);
        setProgressArc(progressArc);
        hoursCompleted.setText("" + activityController.getActiveActivity().getHoursCompleted());
        hoursToComplete.setText("" + activityController.getActiveActivity().getHoursToComplete());
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
        setProgressArc(progressArc);
        user = startController.getUser();
        nameLabel.setText(activityController.getActiveActivity().getName());
        descriptionLabel.setText(activityController.getActiveActivity().getDescription());
        hoursCompleted.setText("" + activityController.getActiveActivity().getHoursCompleted());
        hoursToComplete.setText("" + activityController.getActiveActivity().getHoursToComplete());
    }

    public void setProgressArc(Arc progressArc){
        progressArc.setLength(360*
                (((double)activityController.getActiveActivity().getHoursCompleted())/
                        ((double)activityController.getActiveActivity().getHoursToComplete())));
    }
}
