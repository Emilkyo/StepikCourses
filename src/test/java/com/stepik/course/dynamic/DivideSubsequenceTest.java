package com.stepik.course.dynamic;

import com.stepik.course.divideandconquer.CountSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideSubsequenceTest {
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

    private void inputStream(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(originalOut);
    }

    @Test
    public void firstInputTest() {
        String input = "4\n" +
                "3 6 7 12";
        inputStream(input);

        DivideSubsequence dss = new DivideSubsequence();
        dss.input();
        System.out.println("Input array: " + Arrays.toString(dss.getInputArray()));
        int result = dss.GSSBottomUp(dss.getInputArray());
        int secondResult = dss.MyGSSBottomUp(dss.getInputArray());

        int expected = 3;
        assertEquals(secondResult, result);

    }

    @Test
    public void secondInputTest() {
        String input = "";
        inputStream(input);


        CountSort cs = new CountSort();

        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println("Input array: " + Arrays.toString(cs.getInputArray()));
        System.out.println("Sorted array: " + Arrays.toString(cs.getSortedArray()));
        assertArrayEquals(expected, cs.getSortedArray());

    }
}