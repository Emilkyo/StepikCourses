package com.stepik.courses.methods.dynamic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CalculatorTest {
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
        String input = "96234";
        inputStream(input);
        String expected = "14\n" +
                "1 3 9 10 11 33 99 297 891 2673 8019 16038 16039 48117 96234";
        Calculator calc = new Calculator();


    }

    @Test
    void test1() {
        String input = "1";
        inputStream(input);
        String expected = "0\n" +
                "1";
        Calculator calc = new Calculator();

    }
}

