package com.stepik.course.divideandconquer.pointsAndSegments;

public class QC {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int index = low - 1;
        int temp;

        for (int i = low; i < high; ++i) {
            if (array[i] < pivot) {
                ++index;

                // swap the position
                swap(array, i, index);
            }
        }

        int pivotPosition = ++index;
        swap(array, pivot, index);

        temp = array[index];
        array[index] = pivot;
        array[high] = temp;

        return pivotPosition;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}