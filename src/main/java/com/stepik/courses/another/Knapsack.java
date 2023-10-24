package com.stepik.courses.another;

import java.util.Scanner;

public class Knapsack {
    private int w; // Вместимость рюкзака
    private int n; // Количество предметов
    private int[] things; // Массив весов предметов

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

    public int knapsackSolution() {
        int[] dp = new int[w + 1];

        for (int i = 0; i < n; i++) {
            for (int j = w; j >= things[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - things[i]] + things[i]);
            }
        }

        return dp[w];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.input();
        int result = knapsack.knapsackSolution();
        System.out.println(result);
    }
}
