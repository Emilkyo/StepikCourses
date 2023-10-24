package com.stepik.courses.another;

public class LeetCode343 {
    public LeetCode343() {
        int n = 10;
        integerBreak(n);
    }

    public int integerBreak(int n) {
//        k >= 2
        int dp[] = new int[n + 1];
        int multiply[] = new int[n + 1];
        int nums[] = new int[n + 1];
        //  8   3 * 3 * 2
        for (int k = 2; k <= n; k++) {
            for (int j = 2; j <= k; j++) {
                int temp = n - k;
                if (temp > 1) {
                    nums[k]++;
                    nums[temp]++;
                }
            }
        }
        return 0;
    }
}
