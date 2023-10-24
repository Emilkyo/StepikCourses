package com.stepik.courses.another;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119 {

}

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        if (rowIndex < 0) {
            return result;
        }
        long prev = 1;
        result.add((int) prev);
        for (int i = 1; i < rowIndex + 1; i++) {
            long next_val = prev * (rowIndex - i + 1) / i;
            result.add((int) next_val);
            prev = (int) next_val;
        }
        return result;
    }
}
