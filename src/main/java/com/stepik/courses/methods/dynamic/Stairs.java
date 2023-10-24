package com.stepik.courses.methods.dynamic;

import java.util.Scanner;

public class Stairs {
    private final int result;
    private int[] steps;
    private int n;

    public int getResult() {
        return result;
    }

    public Stairs() {
        input();
        result = maxSumSteps();
    }

    public int maxSumStepsDP() {
        if (n == 1) {
            return steps[0];
        }
        if (n == 2) {
            return Math.max(steps[1], steps[0] + steps[1]);
        }

        int[] dp = new int[n];
        dp[0] = steps[0];
        dp[1] = Math.max(steps[0] + steps[1], steps[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2]) + steps[i];
        }

        return dp[n - 1];
    }

    public int maxSumSteps() {
        if (n == 1) {
            return steps[0];
        }
        if (n == 2) {
            return Math.max(steps[0] + steps[1], steps[1]);
        }
        int prev = steps[0];
        int prev2 = Math.max(steps[0] + steps[1], steps[1]);
        int current = 0;
        for (int i = 2; i < n; i++) {
            current = Math.max(prev2, prev) + steps[i];

            prev = prev2;
            prev2 = current;
        }

        return current;
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            steps = new int[n];
            for (int i = 0; i < n; i++) {
                steps[i] = scanner.nextInt();
            }
        }
    }
}