package com.stepik.course.greedyalgo.Huffman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeHuffmanTest {
    private long startTime;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @BeforeEach
    void startTime() {
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    void finishTime() {
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    @Test
    void test2() {
        String inputTest = "4 14\na: 0\nb: 10\nc: 110\nd: 111\n01001100100111\n";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);

        String expectedOutput = "abacabad";
        new DecodeHuffman();

        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void test7() {
        String inputTest = "3 10\n" +
                "a: 00\n" +
                "b: 1\n" +
                "c: 01\n" +
                "1011001011";
        InputStream inputStream = new ByteArrayInputStream(inputTest.getBytes());
        System.setIn(inputStream);

        String expectedOutput = "bcbabcb";
        new DecodeHuffman();
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}