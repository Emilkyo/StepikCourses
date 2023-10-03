package com.stepik.course.dynamic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackpackTest {
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
    void test1() {
        String input = "10 3\n" +
                "1 4 8";
        inputStream(input);
        int expected = 9;
        Backpack bp = new Backpack();
        assertEquals(expected, bp.getResult());
    }

    @Test
    void test2() {
        String input = "139 7\n" +
                "2 3 4 8 10 20 100";
        inputStream(input);
        int expected = 139;
        Backpack bp = new Backpack();
        assertEquals(expected, bp.getResult());
    }

    @Test
    void test3() {
        String input = "7419 7\n" +
                "2 3 4 8 10 400 7000";
        inputStream(input);
        int expected = 7419;
        Backpack bp = new Backpack();
        assertEquals(expected, bp.getResult());
    }

    @Test
    void test6() {
        String input = "1000 100\n" +
                "5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9" +
                " 9 9 9 9 9 9 10 10 10 10 10 10 10 10 10 10 11 11 11 11 12 12 12 12 12 12 12 13 13 13 13 13 13 13 13 14" +
                " 14 14 14 14 14 15 15 15 15 15 15 15 15";
        inputStream(input);
        int expected = 946;
        Backpack bp = new Backpack();
        assertEquals(expected, bp.getResult());
    }
}