package com.stepik.courses.methods.dynamic;

import java.util.Scanner;

public class Backpack {
    private int w;
    private int n;
    private int[] things;
    private final int result;

    public Backpack() {
        input();
        result = solutionRightToLeft();
        System.out.println(result);
    }

    public int getResult() {
        return result;
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            w = scanner.nextInt();
            n = scanner.nextInt();
            things = new int[n];
            for (int i = 0; i < n; i++) {
                things[i] = scanner.nextInt();
            }
        }
    }

    public int prefixSolution() {
        int[] prev = new int[w + 1];
        prev[0] = 1;
        int[] dp = prev.clone();
        for (int j = 0; j < n; j++) {
            int thing = things[j];
            for (int i = thing; i < w + 1; i++) {
                if (prev[i - thing] == 1) {
                    dp[i] = 1;
                }
            }
            prev = dp;
        }
//        System.out.println(Arrays.toString(prev));
        for (int i = w; i >= 0; i--) {
            if (prev[i] == 1)
                return i;
        }
        return 0;
    }

    public int solutionRightToLeft() {
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int j = 0; j < n; j++) {
            int thing = things[j];
            for (int i = w - 1; i > thing - 1; i--) {
                if (dp[i - thing] == 1) {
                    dp[i] = 1;
                }
            }
        }

        int i = w;
        while (dp[i] == 0)
            i--;
        return i;
    }
}
