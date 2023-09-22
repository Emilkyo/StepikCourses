package com.stepik.course.divideandconquer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
        String input =
                "5 1 5 8 12 13\n" +
                        "5 8 1 23 1 11\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        BinarySearch bs = new BinarySearch();

    }
}