package com.studia;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@MappedSuperclass
@JsonDeserialize(using = ShapeDeserializer.class)
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    public Color color;

    Shape(){
        this.color = new Color(255,255,255,0);
    }

    public Shape(String name) {
        this.name = name;
        this.color = new Color(255,255,255,0);
    }

    public Shape(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorDescription(){
        return color.toString();
    };

    public abstract double getArea();
    public abstract double getPerimeter();
}
