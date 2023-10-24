package com.stepik.courses.javaBasicCourse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BaseTest {

    @Test
    void mergeArrays() {
        int[] a1 = {0, 2, 2, 10, 10, 20};
        int[] a2 = {1, 3, 5, 7, 8, 10, 10};
        //int[] a1 = {-3, -2, -1, 0};
        //int[] a2 = {-1, 1, 1};

        System.out.println(Arrays.toString(Base.mergeArrays(a1, a2)));
    }

    @Test
    void givenTwoSortedArrays_whenMerged_thenReturnMergedSortedArray() {

        int[] foo = {3, 7};
        int[] bar = {4, 8, 11};
        int[] merged = {3, 4, 7, 8, 11};

        assertArrayEquals(merged, Base.mergeArrays(foo, bar));
    }
}