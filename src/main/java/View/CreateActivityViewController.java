package view;

import controller.PlanController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Activity;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateActivityViewController implements Initializable {

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Button backButton;
    @FXML
    public Label profileName;
    @FXML
    public TextField descriptionTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public Button doneButton;
    @FXML
    public ToggleButton refreshToggleButton;
    @FXML
    public Pane hiddenPane;
    @FXML
    public ChoiceBox choiceBox;
    @FXML
    public Pane datePickerPane;
    @FXML
    public DatePicker datePicker;
    @FXML
    public TextField hoursTextField;
    @FXML
    public ToggleButton dueDateToggleButton;

    PlanController planController = PlanController.getInstance();
    Activity activityToCreate = new Activity();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox = new ChoiceBox();
        choiceBox.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7));
    }

    public void handleBackAction(ActionEvent actionEvent) throws IOException {
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

    public void handleDoneAction(ActionEvent actionEvent) throws IOException{
        activityToCreate.setName(nameTextField.getText());
        activityToCreate.setDescription(descriptionTextField.getText());
        activityToCreate.setComplete(false);
        activityToCreate.setHoursCompleted(0);
        activityToCreate.setHoursToComplete(Integer.parseInt(hoursTextField.getText()));
        if(choiceBox.isVisible() && choiceBox.getValue() != null)
            activityToCreate.setRefreshFrequency(Integer.parseInt(choiceBox.getValue().toString()));
        if(datePicker.isVisible() && datePicker.getValue() != null)
            activityToCreate.setDueDate(datePicker.getValue());
        planController.getActivePlan().addActivity(activityToCreate);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation((getClass().getResource("/fxml/planScene.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to the main page!");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleRefreshToggleAction(ActionEvent actionEvent) {
        if(!hiddenPane.isVisible()) {
            hiddenPane.setVisible(true);
            hiddenPane.setDisable(false);
        }
        else{
            hiddenPane.setVisible(false);
            hiddenPane.setDisable(true);
        }
    }

    public void handleToggleDueDateAction(ActionEvent actionEvent) {
        if(!datePicker.isVisible()) {
            datePicker.setVisible(true);
            datePicker.setDisable(false);
        }
        else{
            datePicker.setVisible(false);
            datePicker.setDisable(true);
        }
    }
}
