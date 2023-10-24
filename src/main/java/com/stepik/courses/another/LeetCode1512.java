package com.stepik.courses.another;

import java.util.HashMap;

class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pairs += hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0));
        }
        return pairs;
    }
}