package org.woobolt.algorithms;

import java.util.Stack;

public class InfixToPostfixConverter {

    // Метод для определения приоритета оператора
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Метод для преобразования инфиксной записи в постфиксную
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Если символ - операнд, добавляем его в выходную строку
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // Если символ - открывающая скобка, помещаем его в стек
            else if (ch == '(') {
                stack.push(ch);
            }
            // Если символ - закрывающая скобка, выталкиваем из стека все операторы до открывающей скобки
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Удаляем открывающую скобку из стека
            }
            // Если символ - оператор
            else {
                // Пока приоритет текущего оператора меньше или равен приоритету оператора на вершине стека
                // и стек не пустой, выталкиваем операторы из стека в выходную строку
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch); // Помещаем текущий оператор в стек
            }
        }

        // Выталкиваем оставшиеся операторы из стека в выходную строку
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Неправильное выражение";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }
}