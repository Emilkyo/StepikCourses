package com.stepik.courses.methods.divideandconquer;

import java.util.Scanner;

public class CountSort {
    public int[] getInputArray() {
        return inputArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    int[] inputArray;
    int[] sortedArray;

    public CountSort() {
        input();
        sortedArray = sort(inputArray);
    }

    public int[] sort(int[] array) {
        int[] sortedArray = new int[array.length];
        int min = 11, max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }
        int[] countArray = new int[max - min + 1];
        for (int num : array) {
            countArray[num - min]++;
        }

        int outputIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                sortedArray[outputIndex] = i + min;
                outputIndex++;
                countArray[i]--;
            }
        }
        return sortedArray;
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            inputArray = new int[n];
            for (int i = 0; i < n; i++) {
                inputArray[i] = scanner.nextInt();
            }
        }
    }

    public String printArray(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int j : array) {
            result.append(j).append(" ");
        }
        return result.toString().trim();
    }
}
