package com.stepik.course.greedyalgo.Huffman;

class Node implements Comparable<Node> {
    char letter;
    int frequency;
    Node left, right;

    public Node(char letter) {
        this.letter = letter;
        left = null;
        right = null;
    }

    public Node(char letter, int frequency) {
        this.letter = letter;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}
