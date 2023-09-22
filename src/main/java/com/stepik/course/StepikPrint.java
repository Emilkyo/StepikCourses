//import java.util.*;
//
//
//public class Main {
//    public static void main(String[] args) {
//        DecodeHuffman decodeHuffman = new DecodeHuffman();
//    }
//
//}
//class DecodeHuffman{
//    private static Map<Character, String> encoded;
//
//    private static String decode = "";
//    private static String encodedString;
//
//    private void decodeHuffman() {
//        getInput();
//        createTree();
//        System.out.println(decode);
//    }
//
//    public static void createTree() {
//        PriorityQueue<Node> nodes = new PriorityQueue<>(Collections.reverseOrder());
//        encoded.forEach((key, value) -> nodes.add(new Node(key, value)));
//
//        //Построение дерева Хаффмана
//        while (nodes.size() > 1) {
//            Node left = nodes.poll();
//            Node right = nodes.poll();
//            Node parent = new Node('\0', left.letterCode + right.letterCode);
//            parent.left = left;
//            parent.right = right;
//            nodes.add(parent);
//        }
//
//        decode = decodeString(nodes.peek());
//    }
//
//
//    public static String decodeString(Node root) {
//        StringBuilder decodedString = new StringBuilder();
//        Node currentNode = root;
//
//        for (char bit : encodedString.toCharArray()) {
//            if (bit == '0') {
//                currentNode = currentNode.left;
//            } else if (bit == '1') {
//                currentNode = currentNode.right;
//            }
//
//            if (currentNode.left == null && currentNode.right == null) {
//                // Достигли листа, добавляем символ к расшифрованной строке
//                decodedString.append(currentNode.letter);
//                currentNode = root; // Возвращаемся к корню
//            }
//        }
//        return decodedString.toString();
//    }
//
//
//    public static void getInput() {
//        int k, l;
//        try (Scanner scanner = new Scanner(System.in)) {
//            k = scanner.nextInt();
//            l = scanner.nextInt();
//            encoded = new HashMap<>();
//            for (int i = 0; i < k; i++) {
//                char c = scanner.next().charAt(0);
//                String code = scanner.nextLine().trim();
//                encoded.put(c, code);
//            }
//            encodedString = scanner.next();
//        }
////        System.out.println("Letters amount: " + k);
////        System.out.println("Code length: " + l);
////        System.out.println(encoded);
////        System.out.println(encodedString);
//    }
//}
//
//
//class Node implements Comparable<Node> {
//    char letter;
//    int frequency;
//    String letterCode;
//    Node left, right;
//
//    public Node(char letter, int frequency) {
//        this.letter = letter;
//        this.frequency = frequency;
//    }
//
//    public Node(char letter, String letterCode) {
//        this.letter = letter;
//        this.letterCode = letterCode;
//    }
//
//    @Override
//    public int compareTo(Node other) {
//        return this.letterCode.length() - other.letterCode.length();
//    }
//}