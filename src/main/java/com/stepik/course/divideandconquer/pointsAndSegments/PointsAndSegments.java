package com.stepik.course.divideandconquer.pointsAndSegments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PointsAndSegments {
    private static List<Point> points;
    private static int[] left;
    private static int[] right;
    private static int[] searchNumbers;

    public int[] getSearchNumbers() {
        return searchNumbers;
    }

    PointsAndSegments() {
        QuickSortArray.quickSort(left, 0, left.length - 1);
        QuickSortArray.quickSort(right, 0, right.length - 1);
        searchNumbers = new int[points.size()];
        for (int i = 0; i < searchNumbers.length; i++) {
            int num = points.get(i).coordinate;
            int n = binarySearch(num, left, true);
            int m = binarySearch(num, right, false);
            searchNumbers[i] = n - m;
        }
    }

    private int binarySearch(int num, int[] numbers, boolean findLastSmallerOrEqual) {
        int left = 0;
        int right = numbers.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (findLastSmallerOrEqual) {
                if (numbers[middle] <= num) {
                    result = middle;  // Запоминаем индекс текущего элемента
                    left = middle + 1; // Переходим к правой половине
                } else {
                    right = middle - 1; // Переходим к левой половине
                }
            } else {
                if (numbers[middle] < num) {
                    result = middle;  // Запоминаем индекс текущего элемента
                    left = middle + 1; // Переходим к правой половине
                } else {
                    right = middle - 1; // Переходим к левой половине
                }
            }
        }
        return result;
    }

    public void printIntArray() {
        StringBuilder result = new StringBuilder();
        for (int number : searchNumbers) {
            result.append(number).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    public static void input() {
        int n, m;
        points = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            left = new int[n];
            right = new int[n];
            // Read segments
            for (int i = 0; i < n; i++) {
                left[i] = scanner.nextInt();
                right[i] = scanner.nextInt();
            }
            // Read points
            for (int i = 0; i < m; i++) {
                int point = scanner.nextInt();
                points.add(new Point(point, i));
            }
        }
    }

    public static void print() {
        System.out.println("Left: " + Arrays.toString(left));
        System.out.println("Right: " + Arrays.toString(right));
        StringBuilder resultPoints = new StringBuilder().append("Points: [");
        for (Point point : points) {
            resultPoints.append(point.coordinate).append(" ");
        }
        resultPoints.deleteCharAt(resultPoints.length() - 1).append("]");
        System.out.println(resultPoints);
    }
}

