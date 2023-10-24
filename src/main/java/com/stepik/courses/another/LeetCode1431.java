package com.stepik.courses.another;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {
    public LeetCode1431() {
        Solution1431 s = new Solution1431();
        String input = "[2,3,5,1,3]\n" +
                "3\n" +
                "[4,2,1,1,2]\n" +
                "1\n" +
                "[12,1,12]\n" +
                "10";
        int[] array = new int[]{2, 3, 5, 1, 3};
        s.kidsWithCandies(array, 3);
    }
}

class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies)
                maxCandies = candy;
        }
        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies > maxCandies));
        }
        return result;
    }
}
