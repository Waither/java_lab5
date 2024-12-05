package com.studia;

public class Main {
    public static void main(String[] args) {
        ShapeDAO shapeDAO = new ShapeDAO();

        Shape triangle = new Triangle("Triangle", 9, 5, 5.4);
        Shape circle = new Circle("Circle", 7, new Color(249, 12, 24, 1));
        Shape rectangle = new Rectangle("Rectangle", 4, 6, new Color(249, 12, 24, 1));

        shapeDAO.saveShape(triangle);
        shapeDAO.saveShape(circle);
        shapeDAO.saveShape(rectangle);

        System.out.println("Pobrane figury:");
        Shape retrievedTriangle = shapeDAO.getShape(Triangle.class, triangle.getId());
        Shape retrievedCircle = shapeDAO.getShape(Circle.class, circle.getId());
        Shape retrievedRectangle = shapeDAO.getShape(Rectangle.class, rectangle.getId());

        System.out.println(retrievedTriangle.getName());
        System.out.println(retrievedCircle.getName());
        System.out.println(retrievedRectangle.getName());

        retrievedTriangle.setName("Updated Triangle");
        ((Triangle) retrievedTriangle).setB(12.5);
        shapeDAO.updateShape(retrievedTriangle);

        retrievedCircle.setName("Updated Circle");
        ((Circle) retrievedCircle).setRadius(9.5);
        shapeDAO.updateShape(retrievedCircle);

        retrievedRectangle.setName("Updated Rectangle");
        ((Rectangle) retrievedRectangle).setWidth(10);
        shapeDAO.updateShape(retrievedRectangle);

        System.out.println("\nPo aktualizacji:");
        retrievedTriangle = shapeDAO.getShape(Triangle.class, triangle.getId());
        retrievedCircle = shapeDAO.getShape(Circle.class, circle.getId());
        retrievedRectangle = shapeDAO.getShape(Rectangle.class, rectangle.getId());

        System.out.println(retrievedTriangle.getName() + ", area: " + ((Triangle) retrievedTriangle).getArea() + ", perimeter: " + ((Triangle) retrievedTriangle).getPerimeter() + ", color: " + ((Triangle) retrievedTriangle).getColorDescription());
        System.out.println(retrievedCircle.getName() + ", area: " + ((Circle) retrievedCircle).getArea() + ", perimeter: " + ((Circle) retrievedCircle).getPerimeter() + ", color: " + ((Circle) retrievedCircle).getColorDescription());
        System.out.println(retrievedRectangle.getName() + ", area: " + ((Rectangle) retrievedRectangle).getArea() + ", perimeter: " + ((Rectangle) retrievedRectangle).getPerimeter() + ", color: " + ((Rectangle) retrievedRectangle).getColorDescription());

        System.out.println("\nUsuwanie figur...");
        shapeDAO.deleteShape(triangle);
        shapeDAO.deleteShape(circle);
        shapeDAO.deleteShape(rectangle);

        System.out.println("\nPotwierdzenie usunięcia:");
        Shape deletedTriangle = shapeDAO.getShape(Triangle.class, triangle.getId());
        Shape deletedCircle = shapeDAO.getShape(Circle.class, circle.getId());
        Shape deletedRectangle = shapeDAO.getShape(Rectangle.class, rectangle.getId());

        System.out.println(deletedTriangle == null ? "Triangle został usunięty." : "Triangle istnieje.");
        System.out.println(deletedCircle == null ? "Circle został usunięty." : "Circle istnieje.");
        System.out.println(deletedRectangle == null ? "Rectangle został usunięty." : "Rectangle istnieje.");

        ShapeDAO.shutdown();
    }
}
