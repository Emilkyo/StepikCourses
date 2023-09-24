package com.stepik.course.divideandconquer.pointsAndSegments;

public class Point implements Comparable<Point> {
    int coordinate;
    int index;

    public Point(int coordinate, int index) {
        this.coordinate = coordinate;
        this.index = index;
    }

    @Override
    public int compareTo(Point other) {
        return coordinate - other.coordinate;
    }
}
