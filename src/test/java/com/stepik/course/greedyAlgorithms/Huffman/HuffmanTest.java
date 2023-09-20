package com.stepik.course.greedyAlgorithms.Huffman;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class HuffmanTest {

    @Test
    void getUniqueLetters() {
        String inputTest = "abacadaba";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);
        new Huffman();

    }

    @Test
    void encodeAbacabadTest2() {
        String inputTest = "abacabad";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);
        String expected = "4 14\na: 0\nb: 10\nc: 110\nd: 111\n01001100100111\n";
        Huffman huffman = new Huffman();
//        assertEquals(expected, outContent.toString());
    }

    @Test
    void getATest() {
        String inputTest = "a";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);
        Huffman huffman = new Huffman();

    }

    @Test
    void getAATest() {
        String inputTest = "aa";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);
        Huffman huffman = new Huffman();

    }

    @Test
    void getTest_abacabad() {
        String inputTest = "abacabad";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);
        Huffman huffman = new Huffman();

    }
}