package com.stepik.course.divideandconquer;

import java.util.Scanner;

public class MergeSort {
    private int[] array;
    private long countInversions = 0;

    public int[] getArray() {
        return array;
    }

    public long getCountInversions() {
        return countInversions;
    }

    public MergeSort() {
        input();
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
                countInversions += n1 - i; // Считаем инверсии
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = Integer.parseInt(scanner.nextLine());
            array = new int[length];
            String input = scanner.nextLine().trim(); // Считываем перевод строки после числа
            String[] numbersAsString = input.split(" ");
            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(numbersAsString[i]);
            }
        }
    }
}
