/*
 * Create gradiant text reflecting text using css styling
 */
package helloworldfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ams
 */

public class HelloWorldFX extends Application {
    public HelloWorldFX() {
        System.out.println("Executing Constructor: " + Thread.currentThread().getName());
    }
    @Override
    public void init() {
        System.out.println("Executing Init: " + Thread.currentThread().getName());
    }
    @Override
    public void stop() {
        System.out.println("Executing Stop: " + Thread.currentThread().getName());
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Executing Start: " + Thread.currentThread().getName());
        // Declare Variables
        final int sceneWidth = 500;
        final int sceneHeight = 400;
        // Create Text Component
        Text hWText = new Text("Hello World");
        // Create Reflection Effect
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8f);
        // Add Effect to text component
        hWText.setEffect(reflection);
        // Set Font Color
        hWText.setFill(Color.RED);
        // Set Font type and Size
        hWText.setFont(Font.font("Verdana", 60.0));
        // Move text in Y dirrection
        hWText.setTranslateY(-30);
        // Create Gradient Color Stops
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE), new Stop(1, Color.BLACK)};
        // Create Linear Gradient
        LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        // Create rectangle to simulate background
        Rectangle rectangle = new Rectangle(0, 0, sceneWidth, sceneHeight);
        // Apply gradient to reactange
        rectangle.setFill(linearGradient);
        // Create Root branch
        StackPane root = new StackPane();
        // Add Components to root branch
        root.getChildren().add(rectangle);
        root.getChildren().add(hWText);
        // Create Scene
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        

        //style the window
        primaryStage.setTitle("My HW using FX");
        primaryStage.setScene(scene);
        // Change app layout
        primaryStage.initStyle(StageStyle.DECORATED);
        // Start app
        primaryStage.show();
    }


    public static void main(String args[]){
        launch();
    }
}