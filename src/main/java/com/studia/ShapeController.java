package com.studia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {
    private final ShapeService shapeService;

    @Autowired
    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @PostMapping
    public Shape createShape(@RequestBody Shape shape) {
        return shapeService.saveShape(shape);
    }

    @GetMapping
    public List<? extends Shape> getShapes(@RequestParam(required = false) String type) {
        if (type == null) {
            return shapeService.getAllShapes();
        }
        return shapeService.getShapesByType(type);
    }
}
