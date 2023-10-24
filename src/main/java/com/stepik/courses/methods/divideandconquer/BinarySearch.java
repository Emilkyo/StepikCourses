package com.stepik.courses.methods.divideandconquer;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    private final int[] numbers;

    public int[] getSearchNumbers() {
        return searchNumbers;
    }

    private final int[] searchNumbers;

    public BinarySearch() {
        try (Scanner scanner = new Scanner(System.in)) {
            int numCount = scanner.nextInt();
            numbers = readIntArray(scanner, numCount);

            int searchCount = scanner.nextInt();
            searchNumbers = readIntArray(scanner, searchCount);
        }

        System.out.println("Введенные числа:" + Arrays.toString(numbers));
        System.out.println("Числа для поиска:" + Arrays.toString(searchNumbers));

        for (int i = 0; i < searchNumbers.length; i++) {
            searchNumbers[i] = search(searchNumbers[i]);
        }
        printIntArray();
//        System.out.println("Результат поиска:" + Arrays.toString(searchNumbers));
    }

    private static int[] readIntArray(Scanner scanner, int length) {
        int[] array = new int[length];
        String input = scanner.nextLine().trim(); // Считываем перевод строки после числа
        String[] numbersAsString = input.split(" ");
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(numbersAsString[i]);
        }
        return array;
    }

    /**
     * Explanation of how to find the average:
     * (left + right) / 2 =
     * (left + right — left + left) / 2 =
     * (right — left + 2 * left)  / 2 =
     * [(right — left) / 2] + [2 * left / 2] =
     * (right — left) / 2 + left
     */
    private int search(int k) {
        int left = 0;
        int right = numbers.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (numbers[middle] == k) {
                return middle + 1;
            } else if (numbers[middle] > k)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    private void printIntArray() {
        StringBuilder result = new StringBuilder();
        for (int number : searchNumbers) {
            result.append(number).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
