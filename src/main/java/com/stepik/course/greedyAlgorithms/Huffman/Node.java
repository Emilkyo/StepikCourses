package com.stepik.course.greedyAlgorithms.Huffman;

import org.jetbrains.annotations.NotNull;

public class Node implements Comparable<Node> {
    char letter;
    int frequency;
    Node left, right;

    public Node(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(@NotNull Node other) {
        return this.frequency - other.frequency;
    }
}