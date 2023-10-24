package com.stepik.courses.methods.dynamic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StairsTest {
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
        String input = "2\n" +
                "1 2";
        inputStream(input);
        int expected = 3;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test2() {
        String input = "2\n" +
                "2 -1";
        inputStream(input);
        int expected = 1;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test3() {
        String input = "3\n" +
                "-1 2 1";
        inputStream(input);
        int expected = 3;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test4() {
        String input = "6\n" +
                "0 0 0 4 6 -5";
        inputStream(input);
        int expected = 5;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test5() {
        String input = "5\n" +
                "-64 -16 -13 -9 -48";
        inputStream(input);
        int expected = -73;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test6() {
        String input = "8\n" +
                "3 4 10 10 0 -6 -10 0";
        inputStream(input);
        int expected = 21;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test7() {
        String input = "5\n" +
                "-2 -16 -13 -9 -48";
        inputStream(input);
        int expected = -63;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test8() {
        String input = "7\n" +
                "1 1 -2 -4 -6 2 2";
        inputStream(input);
        int expected = 2;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test9() {
        String input = "5\n" +
                "-64 -16 -13 -9 -48";
        inputStream(input);
        int expected = -73;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }

    @Test
    void test10() {
        String input = "6\n" +
                "0 0 0 4 6 -5";
        inputStream(input);
        int expected = 5;
        Stairs stairs = new Stairs();
        assertEquals(expected, stairs.getResult());
    }
}