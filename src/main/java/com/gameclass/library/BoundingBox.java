package com.gameclass.library;

/**
 * Axis-aligned rectangle for basic collision checks.
 */
public record BoundingBox(double x, double y, double width, double height) {

    public boolean intersects(BoundingBox other) {
        return x < other.x + other.width
                && x + width > other.x
                && y < other.y + other.height
                && y + height > other.y;
    }

    public BoundingBox move(Vector2 delta) {
        return new BoundingBox(x + delta.getX(), y + delta.getY(), width, height);
    }
}
