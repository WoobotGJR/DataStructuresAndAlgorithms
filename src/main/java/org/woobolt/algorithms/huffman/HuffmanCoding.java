package org.woobolt.algorithms.huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {

    private static Node buildHuffmanTree(PriorityQueue<Node> priorityQueue) {
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            priorityQueue.add(parent);
        }
        return priorityQueue.poll();
    }

    private static void generateCodes(Node node, String code, HashMap<Character, String> huffmanCodes) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.data, code);
        }
        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    public HashMap<Character, String> generateHuffmanCodes(String text) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (char c : frequencyMap.keySet()) {
            priorityQueue.add(new Node(c, frequencyMap.get(c)));
        }

        Node root = buildHuffmanTree(priorityQueue);

        HashMap<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    public String encode(String text, HashMap<Character, String> huffmanCodes) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }
        return encodedText.toString();
    }

    public String decode(String encodedText, HashMap<Character, String> huffmanCodes) {
        StringBuilder decodedText = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();

        for (int i = 0; i < encodedText.length(); i++) {
            currentCode.append(encodedText.charAt(i));
            for (char c : huffmanCodes.keySet()) {
                if (huffmanCodes.get(c).equals(currentCode.toString())) {
                    decodedText.append(c);
                    currentCode = new StringBuilder(); // Сбрасываем текущий код
                    break;
                }
            }
        }

        return decodedText.toString();
    }

    public static void printTree(Node node, String prefix) {
        if (node != null) {
            if (node.left != null || node.right != null) {
                System.out.println(prefix + "|-- " + node.frequency);
                printTree(node.left, prefix + "|   ");
                printTree(node.right, prefix + "    ");
            } else {
                System.out.println(prefix + "|-- " + node.data + ":" + node.frequency);
            }
        }
    }
}