package sample;

public class Converter {
    private final StackLink<Character> stack;
    private final QueueLink<Character> queue;

    public Converter() {
        stack = new StackLink<>();
        queue = new QueueLink<>();
    }

    public String postfixExpression() {
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Character firstCharacter = queue.dequeue();
            result.append(firstCharacter);
        }

        return result.toString();
    }

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

    private void handleOperand(Character character) {
        if (!isOperator(character) && character != '(' && character != ')') {
            queue.enqueue(character);
        }
    }
    private void handleLeftParentheses(Character character) {
        if (character == '(') {
            stack.push(character);
        }
    }

    private void handleRightParentheses(Character character) {
        if (character == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                Character topOperator = stack.pop();
                queue.enqueue(topOperator);
            }
            stack.pop();
        }
    }

    private void popRestOfStack() {
        while (!stack.isEmpty()) {
            Character topOperator = stack.pop();
            queue.enqueue(topOperator);
        }
    }

    private void handleOperator(Character character) {
        if (isOperator(character)) {
            if (!stack.isEmpty() && stack.peek() != '(') {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(character) <= precedence(stack.peek())) {
                    Character topOperator = stack.pop();
                    queue.enqueue(topOperator);
                }
            }
            stack.push(character);
        }
    }

    private int precedence(Character operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/', '%' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    private boolean isOperator(char character) {
        return (character == '^' || character == '*' ||
                character == '/' || character == '%' ||
                character == '+' || character == '-' ||
                character == '=');
    }

//    private int assoicitivity(Character operator) {
//        return switch (operator) {
//            case '=', '^' -> -1;
//            default -> 1;
//        };
//    }
}
