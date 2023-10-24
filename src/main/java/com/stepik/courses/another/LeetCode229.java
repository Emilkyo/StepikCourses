package com.stepik.courses.another;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {

    public LeetCode229() {
        Solution229 s = new Solution229();
//        int[] nums = new int[]{3, 2, 3};
//        int[] nums = new int[]{3};
        int[] nums = new int[]{4, 5, 3, 4, 4, 1, 0, -1, -2, 4, 6, 7, 8, 4};
        System.out.println(s.majorityElement(nums));
    }

    public static void main(String[] args) {
        new LeetCode229();
    }
}

class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>(n);
        if (n == 1) {
            result.add(nums[0]);
            return result;
        }
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int j : nums) {
            if (j > maxNum)
                maxNum = j;
            if (j < minNum)
                minNum = j;
        }
        int[] counts = new int[maxNum - minNum + 1];

        for (int num : nums) {
            counts[num - minNum]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > (n / 3))
                result.add(i + minNum);
        }
        return result;
    }
}
