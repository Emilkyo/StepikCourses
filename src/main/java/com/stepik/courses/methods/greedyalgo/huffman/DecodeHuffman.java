package com.stepik.courses.methods.greedyalgo.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DecodeHuffman {
    private static Map<Character, String> encoded;
    private static String decode = "";
    private static String encodedString;

    DecodeHuffman() {
        getInput();
        createTree();
        System.out.println(decode);
    }

    public static void createTree() {
        Node root = new Node('\0');
        for (Map.Entry<Character, String> entry : encoded.entrySet()) {
            Node currentNode = root;
            for (char bit : entry.getValue().toCharArray()) {
                if (bit == '0') {
                    if (currentNode.left == null) {
                        currentNode.left = new Node('\0');
                    }
                    currentNode = currentNode.left;
                } else if (bit == '1') {
                    if (currentNode.right == null) {
                        currentNode.right = new Node('\0');
                    }
                    currentNode = currentNode.right;
                }
            }
            currentNode.letter = entry.getKey();
        }
        decode = decodeString(root);
    }

    public static String decodeString(Node root) {
        StringBuilder decodedString = new StringBuilder();
        Node currentNode = root;

        for (char bit : encodedString.toCharArray()) {
            if (bit == '0') {
                currentNode = currentNode.left;
            } else if (bit == '1') {
                currentNode = currentNode.right;
            }

            if (currentNode.letter != '\0') {
                decodedString.append(currentNode.letter);
                currentNode = root;
            }
        }
        return decodedString.toString();
    }

    public static void getInput() {
        int k, l;
        try (Scanner scanner = new Scanner(System.in)) {
            k = scanner.nextInt();
            l = scanner.nextInt();
            encoded = new HashMap<>();
            for (int i = 0; i < k; i++) {
                char c = scanner.next().charAt(0);
                String code = scanner.next();
                encoded.put(c, code);
            }
            encodedString = scanner.next();
        }
    }


    public void print(int k, int l) {
        System.out.println("Letters: " + k);
        System.out.println("Code length: " + l);
        System.out.println(encoded);
        System.out.println(encodedString);
    }
}

