package com.studia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShapeService {
    private final CircleRepository circleRepository;
    private final RectangleRepository rectangleRepository;
    private final TriangleRepository triangleRepository;

    @Autowired
    public ShapeService(CircleRepository circleRepository, RectangleRepository rectangleRepository, TriangleRepository triangleRepository) {
        this.circleRepository = circleRepository;
        this.rectangleRepository = rectangleRepository;
        this.triangleRepository = triangleRepository;
    }

    public Shape saveShape(Shape shape) {
        if (shape instanceof Circle) {
            return circleRepository.save((Circle) shape);
        } else if (shape instanceof Rectangle) {
            return rectangleRepository.save((Rectangle) shape);
        } else if (shape instanceof Triangle) {
            return triangleRepository.save((Triangle) shape);
        } else {
            throw new IllegalArgumentException("Unsupported shape type");
        }
    }

    public List<Shape> getAllShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.addAll(circleRepository.findAll());
        shapes.addAll(rectangleRepository.findAll());
        shapes.addAll(triangleRepository.findAll());
        return shapes;
    }

    public List<? extends Shape> getShapesByType(String type) {
        switch (type.toLowerCase()) {
            case "circle":
                return circleRepository.findAll();
            case "rectangle":
                return rectangleRepository.findAll();
            case "triangle":
                return triangleRepository.findAll();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}