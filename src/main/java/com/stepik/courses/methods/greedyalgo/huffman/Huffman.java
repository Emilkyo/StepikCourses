package com.stepik.courses.methods.greedyalgo.huffman;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Huffman {

    public Huffman() {
        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine().toLowerCase().trim();
        }
        Map<Character, String> encode = buildLetters(input);
        int uniqueChars = encode.size();

        String encodedString;
        if (uniqueChars == 1)
            encodedString = String.join("", Collections.nCopies(input.length(), "0"));
        else
            encodedString = encodeString(input, encode);
        System.out.println(uniqueChars + " " + encodedString.length());
        encode.forEach((key, value) ->
                System.out.println(key + ": " + (uniqueChars > 1 ? value : "0")));
        System.out.println(encodedString);
    }

    private String repeatString(int count) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < count; i++) {
            r.append("0");
        }
        return r.toString();
    }

    @NotNull
    private Map<Character, String> buildLetters(String input) {
//      Заносим каждый символ в HashMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Создание узлов для букв
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        /*
        for (Iterator<Map.Entry<Character, Integer>> iterator = frequencyMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Character, Integer> entry = iterator.next();
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        */
        frequencyMap.forEach((key, value) -> nodes.add(new Node(key, value)));

        //Построение дерева Хаффмана
        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            nodes.add(parent);
        }

        // Построение кодов для букв
        Map<Character, String> codes = new HashMap<>();
        buildHuffmanCodesHelper(nodes.peek(), "", codes);
        return codes;
    }

    private void buildHuffmanCodesHelper(Node node, String code, Map<Character, String> codes) {
        if (node == null) {
            return;
        }
        if (node.right == null && node.left == null) {
            codes.put(node.letter, code);
        }
        buildHuffmanCodesHelper(node.right, code + "1", codes);
        buildHuffmanCodesHelper(node.left, code + "0", codes);
    }

    public static String encodeString(String s, Map<Character, String> codes) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            encodedString.append(codes.get(c));
        }
        return encodedString.toString();
    }
}
