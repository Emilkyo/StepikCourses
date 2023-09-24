package com.stepik.course.divideandconquer.pointsAndSegments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PointsAndSegmentsTest {
    Long startTime;
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
        Long finishTime = System.currentTimeMillis();
        System.out.println("Process finished in " + (finishTime - startTime) + " ms");
    }

    public PointsAndSegments unionTest() {
        PointsAndSegments.input();
        System.out.println("Before:");
        PointsAndSegments.print();

        System.out.println("\nAfter:");
        PointsAndSegments ps = new PointsAndSegments();
        PointsAndSegments.print();
        ps.printIntArray();
        return ps;
    }

    @Test
    @DisplayName("😱")
//    @Disabled("for demonstration purposes")
    void testInputAndSorting() {
        String input = """
                2 3
                0 5
                7 10
                1 6 11""";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int[] expected = new int[]{1, 0, 0};

        PointsAndSegments ps = unionTest();
        assertArrayEquals(expected, ps.getSearchNumbers());
    }

    @Test
    void test2InputAndSorting() {
        String input = "6 6\n" +
                "0 3\n" +
                "1 3\n" +
                "2 3\n" +
                "3 4\n" +
                "3 5\n" +
                "3 6\n" +
                "1 2 3 4 5 6";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int[] expected = new int[]{2, 3, 6, 3, 2, 1};

        PointsAndSegments ps = unionTest();
        assertArrayEquals(expected, ps.getSearchNumbers());
    }

    @Test
    void test3() {
        String input = "10 5\n" +
                "-2 3\n" +
                "0 3\n" +
                "-1 0\n" +
                "-1 3\n" +
                "0 1\n" +
                "-2 -1\n" +
                "1 3\n" +
                "2 3\n" +
                "1 2\n" +
                "2 3\n" +
                "-3 -1 0 2 3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int[] expected = {0, 4, 5, 7, 6};

        PointsAndSegments ps = unionTest();
        assertArrayEquals(expected, ps.getSearchNumbers());
    }

}