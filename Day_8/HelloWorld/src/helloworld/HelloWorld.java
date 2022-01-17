/*
 * Main Class
 */
package helloworld;

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
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Create the text and apply the styles
        Text text = new Text("Hello World");
        text.setId("text");
        text.setEffect(new Reflection());

        StackPane stackPane = new StackPane(); //Root node
        //width and height
        stackPane.setPrefHeight(300);
        stackPane.setPrefWidth(500);
        stackPane.getChildren().addAll(text); //add the text to the root
        stackPane.setId("text"); //set id to that in the css

        Scene scene = new Scene(stackPane, Color.LIGHTGREY);
        scene.getStylesheets().add("CssStyles/StyleeSheet.css");

        primaryStage.setTitle("My Rectangle App");
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
