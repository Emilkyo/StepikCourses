package com.stepik.courses.methods.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private final int[] result;
    private final int num;
    private int[] prev;

    public Calculator() {
        try (Scanner scanner = new Scanner(System.in)) {
            num = scanner.nextInt();
        }
        result = calculate();
        System.out.println(result[num]);
        System.out.println(printArray(restore()));
    }

    public String printArray(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int j : array) {
            result.append(j).append(" ");
        }
        return result.toString().trim();
    }

    private int[] restore() {
        int length = result[num] + 1;
        int prevNum = num;
        int[] printArray = new int[length];
        while (prevNum != 0) {
            printArray[length - 1] = prevNum;
            prevNum = prev[prevNum];
            length--;
        }
        return printArray;
    }

    private int[] calculate() {
        int[] steps = new int[num + 1];
        prev = new int[num + 1];
        Arrays.fill(steps, 10001);
        steps[1] = 0;
        for (int i = 1; i < num; i++) {
            int plusOne = i + 1;
            int multiplyTwo = i * 2;
            int multiplyThree = i * 3;

            if (plusOne <= num) {
                if ((steps[plusOne] > steps[i])) {
                    prev[plusOne] = i;
                    steps[plusOne] = steps[i] + 1;
                }
            }
            if (multiplyTwo <= num) {
                if ((steps[multiplyTwo] > steps[i])) {
                    prev[multiplyTwo] = i;
                    steps[multiplyTwo] = steps[i] + 1;
                }
            }
            if (multiplyThree <= num) {
                if ((steps[multiplyThree] > steps[i])) {
                    prev[multiplyThree] = i;
                    steps[multiplyThree] = steps[i] + 1;
                }
            }
        }
        return steps;
    }
}