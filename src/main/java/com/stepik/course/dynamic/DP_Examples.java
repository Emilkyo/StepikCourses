package com.stepik.course.dynamic;
/* https://habr.com/ru/articles/343210/#On */

import java.util.Arrays;

public class DP_Examples {
    public int fibonacciDP(int number) {
        int[] dp = new int[number];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number - 1];
    }

    //  нахождения длины наибольшей возрастающей подпоследовательности
    //  longest increasing subsequence
    public int longestIncreasingSubsequenceLength(int[] numbers) {
        if (numbers.length == 1) {
            return 1;
        }
        int n = numbers.length;
        int[] counts = new int[n]; // like a cache

        for (int i = 0; i < n; i++) {
            counts[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (numbers[j] >= numbers[i] && counts[j] <= counts[i]) {
                    counts[j] = counts[i] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < counts[i])
                max = counts[i];
        }
        return max;
    }

    //  нахождения длины наибольшей возрастающей подпоследовательности
    //  с использованием бинарного поиска
    public int LISWithBS(int[] numbers) {
        int n = numbers.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        return 0;
    }

    private int binarySearch(int findNumber, int[] numbers) {
        int left = 0;
        int right = numbers.length;
        int mid = 0;
        while (left <= right) {
            mid = (left + (right - left)) / 2;
            if (findNumber == numbers[mid])
                return mid;
            if (findNumber < numbers[mid]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return -1;
    }

    /* (left + right) / 2 =
     (left + right — left + left) / 2 =
     (right — left + 2 * left)  / 2 =
     [(right — left) / 2] + [2 * left / 2] =
     (right — left) / 2 + left
     */

}
