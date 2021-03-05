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

public class ConverterView extends Application {

    private TextField infixTextField;
    private Label postfixLabel;
    private Button convertButton;
    private Button showButton;

    private ConverterViewDelegate delegate;

    private GridPane view;

    public ConverterView() {
        infixTextField = new TextField();
        infixTextField.setText("A*(B+C)/D");
        postfixLabel = new Label();
        convertButton = new Button("Convert");
        showButton = new Button("Show");

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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller(this);
        primaryStage.setTitle("Postfix Converter");
        primaryStage.setScene(new Scene(view, 500, 375));
        primaryStage.show();
    }

    private void convertButtonPressed(ActionEvent event) {
        delegate.convertButtonPressed(event);
    }

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
