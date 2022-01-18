/*
 * A try to create the notepad without scene editor
 *                      ~(-\-)~
 */
package noteone;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ams
 */
public class NoteOne extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = new Elements(primaryStage);
        primaryStage.setTitle("untitled");
        primaryStage.centerOnScreen();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
