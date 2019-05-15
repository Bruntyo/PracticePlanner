package main;

import controller.MainController;
import controller.StartController;
import controller.StopController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to handle starting and stopping the application
 */
public class Main extends Application {

    StopController stopController;
    StartController startController = StartController.getInstance();
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Starts the application
     * Inherited method from Application
     * @param primaryStage the primary stage of the application
     * @throws Exception possible IOException
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        logger.info("Starting application");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainScene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    /**
     * Calls .stop() method of the application after handling the event with stopController
     * @throws Exception Possible IOException
     */
    @Override
    public void stop() throws Exception {
        logger.info("Shutting down");
        stopController = new StopController(startController.getUser());
        super.stop();
    }

    /**
     * Main method of the program
     * @param args command arguments ignored
     */
    public static void main(String[] args) {
        launch(args);
    }
}
