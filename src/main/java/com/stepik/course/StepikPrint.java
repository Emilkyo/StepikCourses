//import java.util.*;
//
//public class Main {
//    /**
//     * очередь с приоритетами @Huffman
//     */
//    public static void main(String[] args) {
//        Huffman();
//    }
//
//    public static void Huffman() {
////      Получаем ввод
//        String input = "";
//        try (Scanner scanner = new Scanner(System.in)) {
//            input = scanner.nextLine().toLowerCase().trim();
//        }
//
//        Map<Character, String> encode = buildLetters(input);
//
//        String encodedString = encodeString(input, encode);
//        int uniqueChars = encode.size();
//        System.out.println(uniqueChars + " " + encodedString.length());
//        encode.forEach((key, value) ->
//                System.out.println(key + ": " + value));
//        System.out.println(encodedString);
//    }
//
//    private static Map<Character, String> buildLetters(String input) {
////      Заносим каждый символ в HashMap
//        Map<Character, Integer> frequencyMap = new HashMap<>();
//        for (char c : input.toCharArray()) {
//            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//        }
//
//        // Создание узлов для букв
//        PriorityQueue<Node> nodes = new PriorityQueue<>();
//        /*
//        for (Iterator<Map.Entry<Character, Integer>> iterator = frequencyMap.entrySet().iterator(); iterator.hasNext(); ) {
//            Map.Entry<Character, Integer> entry = iterator.next();
//            nodes.add(new Node(entry.getKey(), entry.getValue()));
//        }
//
//        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
//            nodes.add(new Node(entry.getKey(), entry.getValue()));
//        }
//        */
//        frequencyMap.forEach((key, value) -> nodes.add(new Node(key, value)));
//
//        //Построение дерева Хаффмана
//        while (nodes.size() > 1) {
//            Node left = nodes.poll();
//            Node right = nodes.poll();
//            Node parent = new Node('\0', left.frequency + right.frequency);
//            parent.left = left;
//            parent.right = right;
//            nodes.add(parent);
//        }
//
//        // Построение кодов для букв
//        Map<Character, String> codes = new HashMap<>();
//        buildHuffmanCodesHelper(nodes.peek(), "", codes);
//        return codes;
//    }
//
//    private static void buildHuffmanCodesHelper(Node node, String code, Map<Character, String> codes) {
//        if (node == null) {
//            return;
//        }
//        if (node.right == null && node.left == null) {
//            codes.put(node.letter, code);
//        }
//        buildHuffmanCodesHelper(node.right, code + "0", codes);
//        buildHuffmanCodesHelper(node.left, code + "1", codes);
//    }
//
//    public static String encodeString(String s, Map<Character, String> codes) {
//        StringBuilder encodedString = new StringBuilder();
//        for (char c : s.toCharArray()) {
//            encodedString.append(codes.get(c));
//        }
//        return encodedString.toString();
//    }
//}
//
//class Node implements Comparable<Node> {
//    char letter;
//    int frequency;
//    Node left, right;
//
//    public Node(char letter, int frequency) {
//        this.letter = letter;
//        this.frequency = frequency;
//    }
//
//    @Override
//    public int compareTo(Node other) {
//        return this.frequency - other.frequency;
//    }
//}