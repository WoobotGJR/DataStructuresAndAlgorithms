package org.woobolt.algorithms;


import java.util.Stack;

public class ArrayReverser {


     public static StringBuilder reverse(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        char[] charArray = input.toCharArray();

        for (char ch : charArray) {
            stack.push(ch);
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output;
    }

    public static void testReverse(String input) {
        StringBuilder reversed = ArrayReverser.reverse(input);
        System.out.println("Исходная строка: " + input);
        System.out.println("Результат обращения: " + reversed.toString());
        System.out.println();
    }
}
