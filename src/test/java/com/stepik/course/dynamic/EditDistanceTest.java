package com.stepik.course.dynamic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {
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
        String input = "short\n" +
                "ports";
        inputStream(input);
        int expected = 3;
        EditDistance ed = new EditDistance();
//        ed.recursiveSolution();
//        ed.dynamicSolution();
        ed.memDynamicSolution();
        assertEquals(expected, ed.getDistance());
    }


    @Test
    void test2() {
        String input = "editing\n" +
                "distance";
        int expected = 5;
        inputStream(input);
        EditDistance ed = new EditDistance();
//        ed.recursiveSolution();
//        ed.dynamicSolution();
        int result = ed.memDynamicSolution();
//        assertEquals(expected, ed.getDistance());
        assertEquals(expected, result);
    }

    @Test
    void AbAndAbEqualZero() {
        String input = "ab\n" +
                "ab";
        int expected = 0;
        inputStream(input);
        EditDistance ed = new EditDistance();
//        ed.recursiveSolution();
        ed.dynamicSolution();
        assertEquals(expected, ed.getDistance());
    }

}