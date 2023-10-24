package com.stepik.courses.javaBasicCourse.shapes;

public class Circle extends Shape {
    private final Point center;
    private final double radius;

    public Circle(Color color, Point center, double radius) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                ", color=" + getColor() +
                '}';
    }
}
