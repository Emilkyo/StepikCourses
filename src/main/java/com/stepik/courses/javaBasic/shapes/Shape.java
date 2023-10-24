package com.stepik.courses.javaBasic.shapes;

public class Shape {
    private final Color color;

    public Color getColor() {
        return color;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public double getArea() {
        return Double.NaN;
    }
}
