package com.stepik.course.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class DivideSubsequence {
    int[] inputArray;

    public int[] getInputArray() {
        return inputArray;
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            inputArray = new int[n];
            for (int i = 0; i < n; i++) {
                inputArray[i] = scanner.nextInt();
            }
        }
    }

    public int GSSBottomUp(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] % array[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }


    public int MyGSSBottomUp(int[] array) {
        int n = array.length;
        int[] distance = new int[n];

        // Инициализируем массивы distance и prev
        Arrays.fill(distance, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] % array[j] == 0 && distance[i] < distance[j] + 1) {
                    distance[i] = distance[j] + 1;
                }
            }
        }
        int result = 0;
        // Находим индекс элемента, который будет последним в наибольшей подпоследовательности
        for (int i = 0; i < n; i++) {
            result = Math.max(result, distance[i]);
        }
        return result;
    }
}
