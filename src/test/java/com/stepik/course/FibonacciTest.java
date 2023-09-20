package com.stepik.course;

import com.stepik.course.fibonacci.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fibonacciArrayInputThreeIsEqualTwo() {
        int input = 3;
        Fibonacci f = new Fibonacci(input);
        assertEquals(2, f.fibonacciArray());
        System.out.println("Done!");
    }

    @Test
    void fibonacciArrayInputOneIsEqualOne() {
        int input = 1;
        Fibonacci f = new Fibonacci(input);
        assertEquals(1, f.fibonacciArray());
        System.out.println("Done!");
    }

    @Test
    void fibonacciArrayInputZeroIsEqualZero() {
        int input = 0;
        Fibonacci f = new Fibonacci(input);
        assertEquals(0, f.fibonacciArray());
        System.out.println("Done!");
    }

    @Test
    void lastFibDigit() {
        int input = 841645;
        Fibonacci f = new Fibonacci(input);
        assertEquals(5, f.lastFibDigit());
    }

    @Test
    void remainderFib9thFrom2Equal0() {
        int n = 9;
        int m = 2;
        Fibonacci f = new Fibonacci(n, m);
        assertEquals(0, f.getResultFibModulo());
        System.out.println(f.getPeriodList());
    }

    @Test
    void Fib10thFrom2Equal1() {
        int n = 10;
        int m = 2;
        Fibonacci f = new Fibonacci(n, m);
        assertEquals(1, f.getResultFibModulo());
        System.out.println(f.getPeriodList());
    }

    @Test
    void remainderFib10thFrom4Equal3() {
        int n = 10;
        int m = 4;
        Fibonacci f = new Fibonacci(n, m);
        assertEquals(3, f.getResultFibModulo());
        System.out.println(f.getPeriodList());
    }

    @Test
    void remainderFib1025thFrom55Equal5() {
        long n = 1025;
        int m = 55;
        Fibonacci f = new Fibonacci(n, m);
        assertEquals(5, f.getResultFibModulo());
        System.out.println(f.getPeriodList());
    }

    @Test
    void remainderFib12589thFrom369Equal89() {
        int n = 12589;
        int m = 369;
        Fibonacci f = new Fibonacci(n, m);
        assertEquals(89, f.getResultFibModulo());
        System.out.println(f.getPeriodList());
    }

    @Test
    void remainderFib1598753thFrom25897Equa20305() {
        int n = 1598753;
        int m = 25897;
        Fibonacci f = new Fibonacci(n, m);
        assertEquals(20305, f.getResultFibModulo());
        System.out.println(f.getPeriodList());
    }
}