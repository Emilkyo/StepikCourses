package com.stepik.courses.another;

class LeetCode1420 {
    public int numOfArrays(int n, int m, int k) {
        final int mod = 1000000007;
        // Stores num of arrays for given maxNum
        int[][] dp = new int[m + 1][k + 1];
        // Stores num of arrays for all nums upto maxNum
        int[][] prefix = new int[m + 1][k + 1];

        // Stores state of solution for n - 1
        int[][] prevDp = new int[m + 1][k + 1];
        int[][] prevPrefix = new int[m + 1][k + 1];

        for (int j = 1; j <= m; j++) {
            // For a given num maxNum and cost 1, we can only have 1 possible combination i.e [maxNum]
            prevDp[j][1] = 1;
            // For a given num maxNum and cost 1, we can have maxNum total possible combinations i.e
            // [maxNum], [maxNum - 1], [maxNum - 2].... which will sum up to be maxNum
            prevPrefix[j][1] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int maxNum = 1; maxNum <= m; maxNum++) {
                for (int cost = 1; cost <= k; cost++) {
                    // Possible sum of combinations for a given maxNum and cost =
                    //    maxNum * possible sum of combinations of maxNum seen in prevState
                    //  + Total possible sum of combinations of [maxNum -1][cost - 1]
                    dp[maxNum][cost] = (int) (((long) maxNum * prevDp[maxNum][cost]) % mod);
                    if (maxNum > 1 && cost > 1) {
                        dp[maxNum][cost] = (dp[maxNum][cost] + prevPrefix[maxNum - 1][cost - 1]) % mod;
                    }

                    // Total possible combinations for a given maxNum and cost is
                    //     = (total possible combination of maxNum -1 and cost)
                    //         + (possible combinations of maxNum and cost)
                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % mod;
                }
            }

            // Copy current state into prevState to be used for calculations in the next stage
            for (int j = 1; j <= m; j++) {
                System.arraycopy(dp[j], 0, prevDp[j], 0, k + 1);
                System.arraycopy(prefix[j], 0, prevPrefix[j], 0, k + 1);
            }
        }
        return prefix[m][k];
    }
}