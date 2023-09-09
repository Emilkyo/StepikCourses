package com.stepik.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fibonacciArray() {
        int input = 3;
        Fibonacci f = new Fibonacci();
        assertEquals(2, f.FibonacciArray(input));
    }
}