package com.stepik.course.divideandconquer;

public class Search {
    public int search(int[] nums, int target) {
        int A = 0;
        int B = nums.length;

        int index = A + ((target - nums[A]) * (B - A) / (nums[B] - nums[A]));


        for (int i = 0; i < nums.length; i++) {

        }
        return target;
    }
}