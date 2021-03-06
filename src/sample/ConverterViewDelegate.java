package sample;

import javafx.event.ActionEvent;

/**
 * Delegate interface used to communicate from the
 * ConverterView to the controller.
 *
 * Sends a message to the controller when the buttons
 * are pressed.
 *
 * @author Kevin Wood
 * @version 1.0
 */
public interface ConverterViewDelegate {

    /**
     * Sends a delegate message to the class that conforms to ConverterViewDelegate
     * when the convert button is pressed.
     *
     * @param event The event that is passed in from the event handler
     */
    void convertButtonPressed(ActionEvent event);

    /**
     * Sends a delegate message to the class that conforms to ConverterViewDelegate
     * when the show button is pressed.
     *
     * @param event The event that is passed in from the event handler
     */
    void showButtonPressed(ActionEvent event);
}
