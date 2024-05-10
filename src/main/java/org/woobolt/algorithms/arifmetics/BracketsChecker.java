package org.woobolt.algorithms.arifmetics;

import java.util.Stack;

public class BracketsChecker {
    public static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        // Проходим по каждому символу в строке
        for (char ch : input.toCharArray()) {
            // Если это открывающая скобка, помещаем ее в стек
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {  // Если это закрывающая скобка
                // Проверяем, есть ли соответствующая открывающая скобка в стеке
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false; // Не сбалансировано
                }
            }
        }

        // Если в стеке остались открывающие скобки, то это не сбалансированно
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}
