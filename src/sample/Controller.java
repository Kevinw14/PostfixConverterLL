package sample;

import javafx.event.ActionEvent;

/**
 * Controller class that handles the users input and uses the Converter class to transform
 * an infix expression to postfix and returns it back to the view.
 * Conforms to ConverterViewDelegate for the view to communicate to the controller to convert
 * infix expression and updates the view.
 *
 * @author Kevin Wood
 * @version 1.0
 */
public class Controller implements ConverterViewDelegate {

    private final Converter converter;
    private final ConverterView view;

    public Controller(ConverterView view) {
        this.view = view;
        this.view.setDelegate(this);
        this.converter = new Converter();
    }

    /**
     * Delegate Method
     *
     * Gets the infix expression from the TextField and passes it in to
     * the convert method on converter.
     *
     * @param event Event object that is passed in when the button is pressed.
     */
    @Override
    public void convertButtonPressed(ActionEvent event) {
        String expression = view.getInfixTextField().getText();
        converter.convert(expression);
    }

    /**
     * Delegate Method
     *
     * Updates the view's postfixLabel with the postfix expression.
     *
     * @param event Event object that is passed in when the button is pressed.
     */
    @Override
    public void showButtonPressed(ActionEvent event) {
        String postfix = converter.postfixExpression();
        view.getPostfixLabel().setText(postfix);
    }
}
