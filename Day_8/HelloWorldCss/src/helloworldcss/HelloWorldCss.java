/*
 * Create gradiant text reflecting text using css styling
 */
package helloworldcss;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ams
 */

public class HelloWorldCss extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Declare Variables
        final int sceneWidth = 500;
        final int sceneHeight = 400;
        // Create the text and apply the styles
        Text text = new Text("Hello World");
        // id in the css
        text.setId("text");
        // set effect
        text.setEffect(new Reflection());

        StackPane stackPane = new StackPane(); //Root bransh
        // width and height
        stackPane.setPrefHeight(sceneHeight);
        stackPane.setPrefWidth(sceneWidth);
        // Add the text to root branch
        stackPane.getChildren().addAll(text);
        // set effect
        stackPane.setId("text");

        // create scene
        Scene scene = new Scene(stackPane, Color.LIGHTGREY);
        // add the style Sheet to get styles, and connect idS
        scene.getStylesheets().add("CssStyles/StyleeSheet.css");
        
        //style the window
        primaryStage.setTitle("My HW using css");
        primaryStage.setScene(scene); // Add scene to the stage
        primaryStage.show(); //start app
    }

    
    public static void main(String[] args) {
        launch();
    }

}
