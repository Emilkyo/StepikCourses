package com.stepik.course.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetInput {

    private long n;
    private long m;
    static Scanner scanner;

    public long getLongN() {
        return n;
    }


    public long getLongM() {
        return m;
    }

    public void getInputTwoLongNumbers() {
        scanner = new Scanner(System.in);
        n = scanner.nextLong();
        m = scanner.nextLong();
        scanner.close();
    }


    private List<Long> left;
    private List<Long> right;

    public List<Long> getLeftList() {
        return left;
    }

    public List<Long> getRightList() {
        return right;
    }

    public void inputPoints() {
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        left = new ArrayList<>();
        right = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            left.add(scanner.nextLong());
            right.add(scanner.nextLong());
        }
        scanner.close();
    }


    private Long[][] pointsArray;

    public Long[][] getPointsArray() {
        return pointsArray;
    }

    public void setPointsArray(Long[][] pointsArray) {
        this.pointsArray = pointsArray;
    }

    public void inputPointsArray() {
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();
            pointsArray = new Long[n][2];
            for (int i = 0; i < n; i++) {
                pointsArray[i][0] = scanner.nextLong();
                pointsArray[i][1] = scanner.nextLong();
            }
        } finally {
            scanner.close();
        }
    }


}
