package com.stepik.courses.methods.divideandconquer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinarySearchTest {
    private long startTime;
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;

//    @BeforeEach
//    public void setUpStream() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @AfterEach
//    public void restoreStream() {
//        System.setOut(originalOut);
//    }

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
    public void BSTest() {
        String input = "5 1 5 8 12 13\n" +
                "5 8 1 23 1 11\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        BinarySearch bs = new BinarySearch();
    }

    @Test
    public void more3333Test() {
        String input = "11 3 3 3 3 3 3 3 3 4 4 4 \n" +
                "1 3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        BinarySearch bs = new BinarySearch();
    }

    @Test
    public void BSOneElement() {
        String input = "1 4\n" +
                "1 3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        BinarySearch bs = new BinarySearch();
    }

    @Test
    public void BSOneElementToArray() {
        String input = "7 1 5 8 8 8 12 13\n" +
                "1 8\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int[] expected = new int[]{4};
        BinarySearch bs = new BinarySearch();
        assertArrayEquals(expected, bs.getSearchNumbers());
    }

    @Test
    public void Test2() {
        String input = "5 1 5 8 12 13\n" +
                "9 8 1 23 1 11 13 15 13 1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int[] expected = new int[]{4};
        BinarySearch bs = new BinarySearch();
    }
}