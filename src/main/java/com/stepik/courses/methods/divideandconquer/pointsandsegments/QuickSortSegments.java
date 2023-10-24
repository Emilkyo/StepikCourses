package com.stepik.courses.methods.divideandconquer.pointsandsegments;

import java.util.List;

public class QuickSortSegments {
    public static void quickSort(List<Segment> segments, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(segments, low, high);
            quickSort(segments, low, pivotIndex - 1);
            quickSort(segments, pivotIndex + 1, high);
        }
    }

    public static int partition(List<Segment> segments, int low, int high) {
        Segment pivot = segments.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareSegments(segments.get(j), pivot) <= 0) {
                i++;
                swap(segments, i, j);
            }
        }

        swap(segments, i + 1, high);
        return i + 1;
    }

    public static int compareSegments(Segment segment1, Segment segment2) {
        int rightComparison = Integer.compare(segment1.getRight(), segment2.getRight());
        if (rightComparison != 0) {
            return rightComparison;
        }
        return Integer.compare(segment1.getLeft(), segment2.getLeft());
    }

    public static void swap(List<Segment> segments, int i, int j) {
        Segment temp = segments.get(i);
        segments.set(i, segments.get(j));
        segments.set(j, temp);
    }
}
