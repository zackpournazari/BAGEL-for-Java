package com.gameclass.library;

import java.util.List;

/**
 * Time-based frame selector for sprite animations.
 */
public class AnimationTrack {
    private final List<String> frameIds;
    private final double frameDurationSeconds;
    private final boolean looping;
    private double elapsedSeconds;

    public AnimationTrack(List<String> frameIds, double frameDurationSeconds, boolean looping) {
        if (frameIds == null || frameIds.isEmpty()) {
            throw new IllegalArgumentException("frameIds cannot be empty");
        }
        if (frameDurationSeconds <= 0) {
            throw new IllegalArgumentException("frameDurationSeconds must be > 0");
        }

        this.frameIds = List.copyOf(frameIds);
        this.frameDurationSeconds = frameDurationSeconds;
        this.looping = looping;
    }

    public void update(double deltaSeconds) {
        elapsedSeconds += Math.max(0, deltaSeconds);
    }

    public String getCurrentFrameId() {
        int frameIndex = (int) (elapsedSeconds / frameDurationSeconds);
        if (looping) {
            frameIndex = frameIndex % frameIds.size();
        } else {
            frameIndex = Math.min(frameIndex, frameIds.size() - 1);
        }
        return frameIds.get(frameIndex);
    }

    public void reset() {
        elapsedSeconds = 0;
    }
}
