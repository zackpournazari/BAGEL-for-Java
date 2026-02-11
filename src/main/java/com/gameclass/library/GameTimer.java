package com.gameclass.library;

/**
 * Utility for cooldowns, delays, and timed class assignments.
 */
public class GameTimer {
    private final double durationSeconds;
    private double elapsedSeconds;

    public GameTimer(double durationSeconds) {
        if (durationSeconds < 0) {
            throw new IllegalArgumentException("durationSeconds cannot be negative");
        }
        this.durationSeconds = durationSeconds;
    }

    public void tick(double deltaSeconds) {
        elapsedSeconds += Math.max(0, deltaSeconds);
    }

    public boolean isComplete() {
        return elapsedSeconds >= durationSeconds;
    }

    public double getProgress() {
        if (durationSeconds == 0) {
            return 1.0;
        }
        return Math.min(1.0, elapsedSeconds / durationSeconds);
    }

    public void reset() {
        elapsedSeconds = 0;
    }
}
