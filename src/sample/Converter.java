package sample;

/**
 * Converter class used to convert an infix expression to postfix
 * expression using a stack and queue.
 */
public class Converter {

    private final StackLink<Character> stack;
    private final QueueLink<Character> queue;

    public Converter() {
        stack = new StackLink<>();
        queue = new QueueLink<>();
    }

    /**
     * Dequeues the queue and builds a string until the queue is empty.
     *
     * @return string representation of the infix expression after
     * converting it to postfix.
     */
    public String postfixExpression() {
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Character firstCharacter = queue.dequeue();
            result.append(firstCharacter);
        }

        return result.toString();
    }

    /**
     * Loops through the expression and passes the current character in the
     * loop to the helper methods. When finished the final postfix expression
     * characters will be in a queue ready to be dequeued.
     *
     * @param expression the infix expression we want to evaluate.
     */
    public void convert(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            handleOperand(character);
            handleLeftParentheses(character);
            handleRightParentheses(character);
            handleOperator(character);
        }
        popRestOfStack();
    }

    /**
     * Handles the character passed in accordingly if it is an operand.
     * If the character is not an operator, left parentheses, or right parentheses it will
     * add it to the queue.
     *
     * @param character current character in the expression
     */
    private void handleOperand(Character character) {
        if (!isOperator(character) && character != '(' && character != ')') {
            queue.enqueue(character);
        }
    }

    /**
     * Handles the character passed in accordingly if it is left parentheses.
     * If it is a left parentheses we add it to the stack.
     *
     * @param character current character in the expression
     */
    private void handleLeftParentheses(Character character) {
        if (character == '(') {
            stack.push(character);
        }
    }

    /**
     * Handles the character passed in accordingly if it is right parentheses.
     * If the character is a right parentheses, we make sure the stack isn't empty
     * and that the top of the stack isn't a left parentheses. We loop through the stack
     * popping the top and adding it to the queue until we encounter a left parentheses.
     * After we encounter the left parentheses we pop it off the stack and discard it.
     *
     * @param character current character in the expression
     */
    private void handleRightParentheses(Character character) {
        if (character == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                Character topOperator = stack.pop();
                queue.enqueue(topOperator);
            }
            stack.pop();
        }
    }

    /**
     * Handles the character passed in accordingly if it is an operator.
     *
     * If the character passed in is an operator and the stack isn't empty and the top isn't a left parentheses.
     * We loop through the stack until we encounter a left parentheses, as we are looping we are checking
     * the precedence of the operators popped off the stack and the operator passed in.
     * If the operator passed in precedence is less than the top of the stack we pop the top
     * and add it to the queue.
     * If the operator passed in precedence is higher than the top we add it to the stack.
     *
     * @param character current character in the expression
     */
    private void handleOperator(Character character) {
        if (isOperator(character) && !stack.isEmpty() && stack.peek() != '(') {
//            if (!stack.isEmpty() && stack.peek() != '(') {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(character) <= precedence(stack.peek())) {
                    Character topOperator = stack.pop();
                    queue.enqueue(topOperator);
                }
//            }
            stack.push(character);
        }
    }

    /**
     * After the expression has been read any remaining operators in the stack
     * get popped off and get enqueued onto the queue
     */
    private void popRestOfStack() {
        while (!stack.isEmpty()) {
            Character topOperator = stack.pop();
            queue.enqueue(topOperator);
        }
    }

    /**
     * Returns an int with the operators precedence
     * @param operator operator currently being passed in
     * @return int of the precedence of the operator
     */
    private int precedence(Character operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/', '%' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    /**
     * Returns true if the character passed in is an operator.
     * @param character current character in the expression
     * @return true if character is an operator
     */
    private boolean isOperator(char character) {
        return (character == '^' || character == '*' ||
                character == '/' || character == '%' ||
                character == '+' || character == '-' ||
                character == '=');
    }

//    /**
//     * Determines if the operator passed in has a L-R associative
//     * or R-L associative
//     *
//     * R-L = -1
//     * L-R = 1
//     * @param operator operator being currently passed in
//     * @return int showing associative
//     */
//    private int associative(Character operator) {
//        return switch (operator) {
//            case '=', '^' -> -1;
//            default -> 1;
//        };
//    }
}
