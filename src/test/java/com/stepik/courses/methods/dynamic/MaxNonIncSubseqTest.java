package com.stepik.courses.methods.dynamic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxNonIncSubseqTest {
    Long startTime;

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
    }

    @Test
    void test0() {
        String input = "5\n" +
                "5 3 4 4 2";
        inputStream(input);
        String expected = "4\n" +
                "1 3 4 5 ";
        MaxNonIncSubseq mnis = new MaxNonIncSubseq();
        System.out.println(mnis);

    }

    @Test
    void test1() {
        String input = "7\n" +
                "5 3 4 4 2 5 9";
        inputStream(input);
        String expected = "4\n" +
                "1 3 4 5";
        MaxNonIncSubseq mnis = new MaxNonIncSubseq();
        System.out.println(mnis);
        assertEquals(expected, mnis.toString());
    }
}