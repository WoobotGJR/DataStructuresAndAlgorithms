package org.woobolt.algorithms.huffman;

import java.util.HashMap;

public class HuffmanApp {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();

        // Тестирование кода Хаффмана
        testHuffmanCoding(huffmanCoding);
    }

    public static void testHuffmanCoding(HuffmanCoding huffmanCoding) {
        String text = "example text";

        System.out.println("Testing Huffman Coding...");
        System.out.println("Input text: " + text);

        HashMap<Character, String> huffmanCodes = huffmanCoding.generateHuffmanCodes(text);

        System.out.println("\nHuffman Codes:");
        for (char c : huffmanCodes.keySet()) {
            System.out.println(c + ": " + huffmanCodes.get(c));
        }

        String encodedText = huffmanCoding.encode(text, huffmanCodes);
        System.out.println("\nEncoded text: " + encodedText);

        String decodedText = huffmanCoding.decode(encodedText, huffmanCodes);
        System.out.println("Decoded text: " + decodedText);

        if (text.equals(decodedText)) {
            System.out.println("\nTest passed: Decoded text matches original text.");
        } else {
            System.out.println("\nTest failed: Decoded text does not match original text.");
        }
    }
}
