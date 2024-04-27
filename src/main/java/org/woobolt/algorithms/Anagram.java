package org.woobolt.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    static int size; // Size of the word
    static int count; // Count of permutations
    static char[] chars = new char[100]; // Array to hold characters

    // Main method
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a word: ");
        String input = getString(); // Get user input
        size = input.length(); // Set size to length of input word
        count = 0; // Initialize permutation count

        // Convert input word to character array
        for (int j = 0; j < size; j++)
            chars[j] = input.charAt(j);

        // Generate anagrams
        doAnagram(size);
    }

    // Generate anagrams recursively
    public static void doAnagram(int newSize) {
        if (newSize == 1) // Base case: if the size of the word is 1, return
            return;

        // Iterate over the characters and generate anagrams
        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1); // Recursively generate anagrams for a smaller size
            if (newSize == 2) // If the size is reduced to 2, display the word
                displayWord();
            rotate(newSize); // Rotate the characters to generate new permutations
        }
    }

    // Rotate the characters in the array
    private static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = chars[position];
        for (j = position + 1; j < size; j++)
            chars[j - 1] = chars[j];
        chars[j - 1] = temp;
    }

    // Display the generated word
    private static void displayWord() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " "); // Increment and display the permutation count
        for (int j = 0; j < size; j++)
            System.out.print(chars[j]); // Display the characters
        System.out.print("\t");
        System.out.flush();
        if (count % 6 == 0) // Move to the next line after every 6 permutations
            System.out.println();
    }

    // Method to get user input
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine(); // Read user input
    }
}
