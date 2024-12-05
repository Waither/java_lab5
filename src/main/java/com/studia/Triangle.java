package com.studia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {

    @Column(name = "a", nullable = false)
    private double a;

    @Column(name = "b", nullable = false)
    private double b;

    @Column(name = "c", nullable = false)
    private double c;

    public Triangle(String name, double a, double b, double c, Color color) {
        super(name, color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {}

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a+b+c)/2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
