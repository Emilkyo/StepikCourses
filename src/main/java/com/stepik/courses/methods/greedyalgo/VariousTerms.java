package com.stepik.courses.methods.greedyalgo;

//https://stepik.org/lesson/13238/step/11?unit=3424

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VariousTerms {
    private final List<Integer> result;

    public VariousTerms() {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }
        result = new ArrayList<>();
        int current = 1;
        while (n > 0) {
            if (n <= 2 * current) {
                result.add(n);
                break;
            }
            result.add(current);
            n -= current;
            current++;
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(result.size()).append("\n");
        for (int i : result) {
            output.append(i).append(" ");
        }
        return output.toString().trim();
    }
}