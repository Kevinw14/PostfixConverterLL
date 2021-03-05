package sample;

import javafx.event.ActionEvent;

public class Controller implements ConverterViewDelegate {

    private Converter converter;
    private ConverterView view;

    public Controller(ConverterView view) {
        this.view = view;
        this.view.setDelegate(this);
        this.converter = new Converter();
    }

    @Override
    public void convertButtonPressed(ActionEvent event) {
        String expression = view.getInfixTextField().getText();
        converter.convert(expression);
    }

    @Override
    public void showButtonPressed(ActionEvent event) {
        String postfix = converter.postfixExpression();
        view.getPostfixLabel().setText(postfix);
    }
}
