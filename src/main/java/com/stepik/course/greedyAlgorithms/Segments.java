package com.stepik.course.greedyAlgorithms;

import com.stepik.course.fibonacci.GetInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://stepik.org/lesson/13238/step/9?unit=3424
public class Segments {
    private final Long[][] segments;

    public Long[][] getSegments() {
        return segments;
    }

    public Segments(GetInput input) {
        segments = input.getPointsArray();
        sortLines();
        print(findPoints());
    }

    private void print(List<Long> result) {
        System.out.println(result.size());
        String resultString = "";
        for (Long aLong : result)
            resultString += (aLong + " ");
        System.out.println(resultString.trim());
    }

    private void sortLines() {
        System.out.println("Before: \n" + Arrays.deepToString(segments));
        Arrays.sort(segments, Comparator.comparingLong(a -> a[1]));
        System.out.println("After: \n" + Arrays.deepToString(segments));
    }

    private List<Long> findPoints() {
        int n = segments.length;
        List<Long> points = new ArrayList<>();
        points.add(segments[0][1]);
        for (int i = 1; i < n; i++) {
            if (points.get(points.size() - 1) < segments[i][0]) {
                points.add(segments[i][1]);
            }
        }
        System.out.println("points");
        return points;
    }
}
