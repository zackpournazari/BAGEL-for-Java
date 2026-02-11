package com.gameclass.library;

import java.util.Objects;

/**
 * Immutable 2D vector utility for movement and geometry calculations.
 */
public final class Vector2 {
    private final double x;
    private final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 scale(double scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    public double dot(Vector2 other) {
        return x * other.x + y * other.y;
    }

    public double length() {
        return Math.sqrt(dot(this));
    }

    public Vector2 normalize() {
        double len = length();
        if (len == 0.0) {
            return new Vector2(0, 0);
        }
        return scale(1.0 / len);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector2 vector2)) {
            return false;
        }
        return Double.compare(x, vector2.x) == 0 && Double.compare(y, vector2.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Vector2{" + "x=" + x + ", y=" + y + '}';
    }
}
