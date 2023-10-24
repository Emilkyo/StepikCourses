package com.stepik.courses.another;

public class LeetCode2038 {
    public static void main(String[] args) {

        SolutionTwo s = new SolutionTwo();
        String colors = "AAABABB";
        System.out.println(s.winnerOfGame(colors));
    }
}

class SolutionTwo {
    public boolean winnerOfGame(String colors) {
        int result = 0;
        int[] num = new int[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            num[i] = colors.charAt(i) - '0';
        }
        for (int i = 1; i < colors.length() - 1; i++) {
            if (num[i - 1] == num[i] && num[i] == num[i + 1]) {
                if (num[i] == 17)
                    result++;
                else
                    result--;
            }
        }
        return result > 0;
    }
}