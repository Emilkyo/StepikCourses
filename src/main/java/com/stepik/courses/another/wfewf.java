package com.stepik.courses.another;

public class wfewf {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        int[] mergeArray = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a1[i] < a2[j]) {
                mergeArray[k++] = a1[i++];
            } else {
                mergeArray[k++] = a2[j++];
            }
        }

        while (i < n) {
            mergeArray[k++] = a1[i++];
        }

        while (j < m) {
            mergeArray[k++] = a2[j++];
        }

        return mergeArray;
    }

}
