package com.stepik.courses.javaBasicCourse.shapes;

public class Square extends Shape {
    private final Point point;
    private final double size;

    public Square(Color color, Point point, double size) {
        super(color);
        this.point = point;
        this.size = size;
    }

    public Point getPoint() {
        return point;
    }

    public double getSize() {
        return size;
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public String toString() {
        return "Square{" +
                "point=" + point +
                ", size=" + size +
                ", color=" + getColor() +
                '}';
    }
}
