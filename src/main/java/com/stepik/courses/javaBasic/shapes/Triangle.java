package com.stepik.courses.javaBasic.shapes;

public class Triangle extends Shape {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Color color, Point a, Point b, Point c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    /*
    @Override
    public double getArea() {
        // Площадь треугольника находится через определитель
        // | (Xa - Xc) * (Yb - Yc) - (Xb - Xc) * (Ya - Yc) | / 2
        double S = (r + s + t) / 2;

        // Finding the area of the triangle
        double A = Math.sqrt(S * (S - r) * (S - s)
                * (S - t));
        return A;
    }
    */

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", color=" + getColor() +
                '}';
    }
}
