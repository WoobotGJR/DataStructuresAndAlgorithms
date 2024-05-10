package org.woobolt.algorithms.arifmetics.stack_based;
import java.util.Stack;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Если символ - операнд, помещаем его в стек
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Преобразуем символ в целое число и помещаем в стек
            }
            // Если символ - оператор, выполняем соответствующую операцию
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Неправильное выражение");
                }
            }
        }

        // Результат будет на вершине стека
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "234*+82/-";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Результат вычисления: " + result);
    }
}

