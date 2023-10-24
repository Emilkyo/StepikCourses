package com.stepik.courses.another;

//  https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class LeetCode {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Let's take LeetCode contest";
        String result = solution.reverseWords(s);
        System.out.println(result);
        s = "God Ding";
        result = solution.reverseWords(s);
        System.out.println(result);
    }
}

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String word : s.split("\\s+")) {
            char[] wordCharArray = word.toCharArray();
            for (int i = wordCharArray.length; i > 0; i--) {
                result.append(wordCharArray[i - 1]);
            }
            result.append(" ");
        }
        result.setLength(result.length() - 1);
        System.gc();
        return result.toString();
    }
}
