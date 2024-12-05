package com.studia;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ShapeDeserializer extends JsonDeserializer<Shape> {
    @Override
    public Shape deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode node = mapper.readTree(parser);

        Color color = null;
        if (node.has("color")) {
            JsonNode colorNode = node.get("color");
            color = new Color(
                colorNode.get("red").asInt(),
                colorNode.get("green").asInt(),
                colorNode.get("blue").asInt(),
                (float) colorNode.get("alpha").asDouble()
            );
        }

        if (node.has("radius")) {
            Circle circle = new Circle();
            circle.setRadius(node.get("radius").asDouble());
            circle.setName(node.get("name").asText());
            circle.color = color;
            return circle;
        }
        else if (node.has("a") && node.has("b") && node.has("c")) {
            Triangle triangle = new Triangle();
            triangle.setA(node.get("a").asDouble());
            triangle.setB(node.get("b").asDouble());
            triangle.setC(node.get("c").asDouble());
            triangle.setName(node.get("name").asText());
            triangle.color = color;
            return triangle;
        }
        else if (node.has("height") && node.has("width")) {
            Rectangle rectangle = new Rectangle();
            rectangle.setHeight(node.get("height").asDouble());
            rectangle.setWidth(node.get("width").asDouble());
            rectangle.setName(node.get("name").asText());
            rectangle.color = color;
            return rectangle;
        }

        throw new IllegalArgumentException("Nieznany typ Shape w JSON");
    }
}
