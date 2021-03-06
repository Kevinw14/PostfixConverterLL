package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * ConverterView class sets up a view that gets an infix expression
 * from the user and will convert it into a postfix expression and
 * display it to this user
 *
 * @author Kevin Wood
 * @version 1.0
 */
public class ConverterView extends Application {

    private final TextField infixTextField;
    private final Label postfixLabel;

    private ConverterViewDelegate delegate;

    private final GridPane view;

    public ConverterView() {
        infixTextField = new TextField();
        infixTextField.setText("A*(B+C)/D");
        postfixLabel = new Label();
        Button convertButton = new Button("Convert");
        Button showButton = new Button("Show");

        view = new GridPane();
        view.add(infixTextField,1, 0);
        view.add(postfixLabel,2, 0);
        view.add(convertButton,1, 1);
        view.add(showButton, 2, 1);
        view.setHgap(80);
        view.setVgap(80);
        Insets insets = new Insets(50,0,0,0);
        view.setPadding(insets);

        convertButton.setOnAction(this::convertButtonPressed);
        showButton.setOnAction(this::showButtonPressed);

    }

    /**
     * Creates a new Controller and passes this view in.
     * Sets up the overall UI for this application and sets the title.
     *
     * @param primaryStage Stage that used to present the overall UI of the JavaFX application
     */
    @Override
    public void start(Stage primaryStage) {
        new Controller(this);
        primaryStage.setTitle("Postfix Converter");
        primaryStage.setScene(new Scene(view, 500, 375));
        primaryStage.show();
    }

    /**
     * Sends a delegate message to the controller when the convert
     * button is pressed.
     *
     * @param event Event object that is passed in when the button is pressed.
     */
    private void convertButtonPressed(ActionEvent event) {
        delegate.convertButtonPressed(event);
    }

    /**
     * Sends a delegate message to the controller when the show
     * button is pressed.
     *
     * @param event Event object that is passed in when the button is pressed.
     */
    private void showButtonPressed(ActionEvent event) {
        delegate.showButtonPressed(event);
    }

    public TextField getInfixTextField() {
        return infixTextField;
    }
    public Label getPostfixLabel() {
        return postfixLabel;
    }
    public void setDelegate(ConverterViewDelegate delegate) {
        this.delegate = delegate;
    }
}
