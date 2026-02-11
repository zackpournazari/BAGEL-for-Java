package com.gameclass.library;

/**
 * Generic game object that has a name, transform data, and optional hit box.
 */
public class GameEntity {
    private final String id;
    private Vector2 position;
    private Vector2 velocity;
    private BoundingBox hitBox;

    public GameEntity(String id, Vector2 position) {
        this.id = id;
        this.position = position;
        this.velocity = new Vector2(0, 0);
    }

    public String getId() {
        return id;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public BoundingBox getHitBox() {
        return hitBox;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setHitBox(double width, double height) {
        this.hitBox = new BoundingBox(position.getX(), position.getY(), width, height);
    }

    public void update(double deltaSeconds) {
        Vector2 delta = velocity.scale(deltaSeconds);
        position = position.add(delta);
        if (hitBox != null) {
            hitBox = hitBox.move(delta);
        }
    }

    public boolean collidesWith(GameEntity other) {
        return hitBox != null && other.hitBox != null && hitBox.intersects(other.hitBox);
    }
}
