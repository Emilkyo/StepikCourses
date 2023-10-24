package com.stepik.courses.another;

import java.util.Arrays;

public class LeetCode2742 {
    public static void main(String[] args) {
        int[] cost = {2, 3, 4, 2};
        int[] time = {1, 1, 1, 1};
        int result = paintWalls(cost, time);
        System.out.println(result);
    }


    public static int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
            }
        }
        return dp[n];
    }
}
