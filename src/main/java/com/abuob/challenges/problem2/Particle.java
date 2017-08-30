package com.abuob.challenges.problem2;

import com.abuob.challenges.problem2.enums.Direction;

public class Particle {

    private final Direction direction;
    private final int initialPosition;
    private final int speed;

    public Particle(Direction direction, int initialPosition, int speed) {
        this.direction = direction;
        this.initialPosition = initialPosition;
        this.speed = speed;
    }

    public int getPositionOverTime(int time) {
        if (direction == Direction.RIGHT) {
            return initialPosition + (time * speed);
        }
        return initialPosition - (time * speed);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getInitialPosition() {
        return initialPosition;
    }

    public int getSpeed() {
        return speed;
    }
}