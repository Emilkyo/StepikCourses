package com.stepik.courses.methods.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// Наибольшая невозрастающая подпоследовательность
public class MaxNonIncSubseq {
    private int n;
    private int[] array;
    private int[] subsequenceIndexes;
    private final int INF = 1000000000;

    public MaxNonIncSubseq() {
        input();
        find();
    }

    private void find() {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -INF);
        List<int[]> prev = new ArrayList<>(n);  // список для хранения информации о предках

        for (int i = 0; i < n; i++) {
            int j = array[i];
            int left = 0;
            int right = n;
            while (right - left > 1) {
                int middle = (left + right) / 2;
                if (dp[middle] < j) {
                    right = middle;
                } else {
                    left = middle;
                }
            }
            dp[right] = j;

            // Сохраняем информацию о предке (right, i, A[i])
            int[] parent = new int[]{right, i, j};
            prev.add(parent);
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != INF && dp[i] != -INF) {
                count++;
            }
        }
        subsequenceIndexes = new int[count];

        for (int i = prev.size() - 1; i >= 0; i--) {
            if (prev.get(i)[0] == count) {
                subsequenceIndexes[count - 1] = prev.get(i)[1] + 1;
                count--;
            }
        }

//        int[] subsequenceLength = new int[count];
//        for (int i = 0, k = 0; i < dp.length; i++) {
//            if (dp[i] != INF && dp[i] != -INF) {
//                subsequenceLength[k] = dp[i];
//                k++;
//            }
//        }
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(subsequenceIndexes.length).append('\n');
        for (int subsequenceIndex : subsequenceIndexes) {
            result.append(subsequenceIndex).append(" ");
        }
        return result.toString().trim();
    }
}