
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a VBox layout
        VBox vbox = new VBox(10); // 10 pixels spacing between elements
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;"); // Styling for the VBox

        // Create components
        Label label = new Label("Enter Your Name:");
        TextField textField = new TextField();
        textField.setPromptText("Name");

        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        Label resultLabel = new Label();

        // Add action to the Submit button
        submitButton.setOnAction(e -> {
            String name = textField.getText();
            if (name.isEmpty()) {
                resultLabel.setText("Please enter your name.");
            } else {
                resultLabel.setText("Hello, " + name + "!");
            }
        });

        // Add action to the Clear button
        clearButton.setOnAction(e -> {
            textField.clear();
            resultLabel.setText("");
        });

        // Add components to the VBox
        vbox.getChildren().addAll(label, textField, submitButton, clearButton, resultLabel);

        // Create the Scene
        Scene scene = new Scene(vbox, 300, 200);

        // Configure the Stage
        primaryStage.setTitle("JavaFX Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
