package com.stepik.courses.jusanExam;

import java.util.Arrays;

public class JusanExam {
    public static void main(String[] args) {
        int[] testArray = new int[]{1, 2, 3};
        int target = 5;
        twoSumDP(testArray, target);
    }


    // Неструктурированное описание задачи.
    // Мне нужно найти только два числа из массива?
    // Или это задача на поиск подмножества массива с определенной суммой?

    public static void twoSumDP(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        // Заполнение таблицы динамического программирования
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // Восстановление индексов элементов из таблицы
        if (dp[nums.length][target]) {
            int[] subsetIndexes = new int[nums.length];
            int index = nums.length;
            int remainingTarget = target;

            while (index > 0 && remainingTarget > 0) {
                if (dp[index][remainingTarget] && !dp[index - 1][remainingTarget]) {
                    subsetIndexes[index - 1] = index - 1;
                    remainingTarget -= nums[index - 1];
                }
                index--;
            }
            printArray(subsetIndexes);
        }
        printArray(new int[]{-1});
    }


    public static void twoSum(int[] array, int target) {
        int[] dp = new int[array.length + 1];

        Arrays.sort(array);
        int result = search(target, array);

        printArray(dp);
        System.out.println(-1);
    }

    private static int search(int k, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == k) {
                return middle + 1;
            } else if (nums[middle] > k)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return left;
    }

    private static void printArray(int[] array) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            string.append(array[i]).append(" ");
        }
        System.out.println(string.toString().trim());
    }
}

