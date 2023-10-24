package com.stepik.courses.jusanExam;

import java.util.Arrays;

public class SubsetSum {
    private static int[] findSubsetWithSum(int[] nums, int target) {
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

            return subsetIndexes;
        }

        return new int[0]; // Если подмножество не найдено
    }
    // Неструктурированное описание задачи.
    // Мне нужно найти только два числа из массива?
    // Или это задача на поиск подмножества массива с определенной суммой?

    public static void twoSum(int[] nums, int target) {
        int[] subsetIndexes = findSubsetWithSum(nums, target);
        System.out.println(Arrays.toString(subsetIndexes));
        if (subsetIndexes.length > 0) {
            //            System.out.print("Индексы элементов подмножества: ");
            for (int index : subsetIndexes) {
                if (index > 0)
                    System.out.print(index + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 8};
        int target = 10;
        twoSum(nums, target);
    }
}
