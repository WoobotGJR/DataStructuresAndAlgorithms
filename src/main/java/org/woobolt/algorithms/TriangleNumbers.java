package org.woobolt.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleNumbers {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number");
        int number = getInt();
        int answer = triangle(number);
        System.out.println(answer);
    }

    public static int triangle(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number + triangle(number - 1);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
