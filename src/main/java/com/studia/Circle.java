package com.studia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "circles")
public class Circle extends Shape {

    @Column(name = "radius", nullable = false)
    private double radius;

    public Circle(String name, double radius, Color color) {
        super(name, color);
        this.radius = radius;
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public Circle() {}

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
