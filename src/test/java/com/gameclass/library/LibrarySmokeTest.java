package com.gameclass.library;

import java.util.List;

public final class LibrarySmokeTest {
    public static void main(String[] args) {
        Vector2 start = new Vector2(1, 2);
        Vector2 velocity = new Vector2(3, 4);

        GameEntity player = new GameEntity("player", start);
        player.setVelocity(velocity);
        player.setHitBox(10, 10);
        player.update(0.5);

        assert player.getPosition().equals(new Vector2(2.5, 4.0));

        GameEntity enemy = new GameEntity("enemy", new Vector2(5, 5));
        enemy.setHitBox(10, 10);
        assert player.collidesWith(enemy);

        AnimationTrack track = new AnimationTrack(List.of("idle_1", "idle_2"), 0.1, true);
        track.update(0.25);
        assert "idle_1".equals(track.getCurrentFrameId());

        GameTimer timer = new GameTimer(2.0);
        timer.tick(1.0);
        assert !timer.isComplete();
        timer.tick(1.2);
        assert timer.isComplete();
    }
}
