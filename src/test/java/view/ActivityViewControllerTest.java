package view;

import controller.ActivityController;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import model.Activity;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityViewControllerTest {

    private Arc progressArc = new Arc();
    ActivityController activityController = ActivityController.getInstance();
    ActivityViewController activityViewController = new ActivityViewController();

    @Test
    public void setProgressArcTest() {
        Activity activity = new Activity();
        activityController.setActiveActivity(activity);
        activityController.getActiveActivity().setName("TestActivity");
        activityController.getActiveActivity().setHoursToComplete(100);
        activityController.getActiveActivity().setHoursCompleted(75);
        activityController.getActiveActivity().setDescription("TestActivity");

        activityViewController.setProgressArc(progressArc);

        assertEquals("Check length (angle) of progress arc",
                360.0 * (75.0 / 100.0),
                progressArc.getLength(),
                1);
    }
}