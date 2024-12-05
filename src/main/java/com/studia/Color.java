package com.studia;

import jakarta.persistence.*;

@Embeddable
public record Color(int red, int green, int blue, float alpha) {
    public Color {
        if (red < 0 || red > 255) {
            throw new IllegalArgumentException("Red must be between 0 and 255");
        }
        if (green < 0 || green > 255) {
            throw new IllegalArgumentException("Green must be between 0 and 255");
        }
        if (blue < 0 || blue > 255) {
            throw new IllegalArgumentException("Blue must be between 0 and 255");
        }
        if (alpha < 0.0f || alpha > 1.0f) { // Ensure alpha is within valid range
            throw new IllegalArgumentException("Alpha must be between 0.0 and 1.0");
        }
    }

    public Color(int red, int green, int blue) {
        this(red, green, blue, 0.0f);
    }
}