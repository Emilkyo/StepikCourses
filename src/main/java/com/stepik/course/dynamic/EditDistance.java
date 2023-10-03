package com.stepik.course.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {
    private final int[][] dynamicArray;
    char[] firstArray;
    char[] secondArray;
    private int m;
    private int n;

    public int getDistance() {
        return dynamicArray[n][m];
    }

    public EditDistance() {
        input();
        n = firstArray.length;
        m = secondArray.length;
        if (n < m) {
            // Если второе слово короче, меняем их местами
            char[] temp = firstArray;
            firstArray = secondArray;
            secondArray = temp;

            int tempLength = n;
            n = m;
            m = tempLength;
        }
        dynamicArray = new int[n + 1][m + 1];
    }

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            firstArray = scanner.nextLine().trim().toCharArray();
            secondArray = scanner.nextLine().trim().toCharArray();
        }
    }

    public void recursiveSolution() {
        // Fill each row with -1
        for (int[] row : dynamicArray)
            Arrays.fill(row, -1);
        System.out.println(EditDistTD(n, m));
    }

    public int EditDistTD(int i, int j) {
        if (i == 0) {
            dynamicArray[i][j] = j;
        } else if (j == 0) {
            dynamicArray[i][j] = i;
        } else {
            int ins = EditDistTD(i, j - 1) + 1;
            int del = EditDistTD(i - 1, j) + 1;
            int sub = EditDistTD(i - 1, j - 1) + diffChars(firstArray[i - 1], secondArray[j - 1]);
            dynamicArray[i][j] = Math.min(Math.min(ins, del), sub);
        }
        return dynamicArray[i][j];
    }

    private int diffChars(char i, char j) {
        return i == j ? 0 : 1;
    }

    public int EditDistBU() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int c = diffChars(firstArray[i - 1], secondArray[j - 1]);
                int ins = dynamicArray[i - 1][j] + 1;
                int del = dynamicArray[i][j - 1] + 1;
                int sub = dynamicArray[i - 1][j - 1] + c;
                dynamicArray[i][j] = Math.min(Math.min(ins, del), sub);
            }
        }
        return dynamicArray[n][m];
    }

    public void dynamicSolution() {
        for (int i = 0; i < n + 1; i++) {
            dynamicArray[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dynamicArray[0][j] = j;
        }
        System.out.println(EditDistBU());
    }

    public int memDynamicSolution() {
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            int prevDiagonal = prev[0];

            for (int j = 1; j <= n; j++) {
                int diff = diffChars(firstArray[j - 1], secondArray[i - 1]);
                curr[j] = Math.min(Math.min(prev[j] + 1, curr[j - 1] + 1), prevDiagonal + diff);

                // Обновляем prevDiagonal для следующей итерации
                prevDiagonal = prev[j];
            }

            // Переприсваиваем curr в prev для следующей итерации
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }
        return curr[n];
    }
}