package com.stepik.course.divideandconquer;

import java.util.Scanner;

public class BinarySearch {
    public BinarySearch() {
        int[] numbers;
        int[] searchNumbers;

        try (Scanner scanner = new Scanner(System.in)) {
            int numCount = scanner.nextInt();
            numbers = readIntArray(scanner, numCount);

            int searchCount = scanner.nextInt();
            searchNumbers = readIntArray(scanner, searchCount);
        }

        System.out.println("Введенные числа:");
        printIntArray(numbers);

        System.out.println("Числа для поиска:");
        printIntArray(searchNumbers);
    }

    public static int[] readIntArray(Scanner scanner, int length) {
        int[] array = new int[length];
        scanner.nextLine(); // Считываем перевод строки после числа
        String input = scanner.nextLine();
        String[] numbersAsString = input.split(" ");
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(numbersAsString[i]);
        }
        return array;
    }

    public static void printIntArray(int[] array) {
        for (int number : array) {
            System.out.println(number);
        }
    }


}
