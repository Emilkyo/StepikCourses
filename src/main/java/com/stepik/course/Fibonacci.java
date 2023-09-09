package com.stepik.course;

public class Fibonacci {
    public int FibonacciArray(int n) {
        int[] array = new int[40];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[n];
    }
}