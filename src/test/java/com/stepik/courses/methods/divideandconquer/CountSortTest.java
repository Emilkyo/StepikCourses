package com.stepik.courses.methods.divideandconquer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountSortTest {
    Long startTime;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    void startTime() {
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    void finishTime() {
        Long finishTime = System.currentTimeMillis();
        System.out.println("Process finished in " + (finishTime - startTime) + " ms");
    }

    @Test
    public void firstInputTest() {
        String input = "5\n" +
                "2 3 9 2 9";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(originalOut);

        CountSort cs = new CountSort();

        int[] expected = {2, 2, 3, 9, 9};
        System.out.println("Input array: " + Arrays.toString(cs.getInputArray()));
        System.out.println("Sorted array: [" + cs.printArray(cs.getSortedArray()) + "]");
        assertArrayEquals(expected, cs.getSortedArray());

    }

    @Test
    public void secondInputTest() {
        String input = "20\n" +
                "1 10 1 10 10 10 1 1 1 10 1 10 1 10 10 10 1 1 1 10";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(originalOut);

        CountSort cs = new CountSort();

        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println("Input array: " + Arrays.toString(cs.getInputArray()));
        System.out.println("Sorted array: " + Arrays.toString(cs.getSortedArray()));
        assertArrayEquals(expected, cs.getSortedArray());

    }
}