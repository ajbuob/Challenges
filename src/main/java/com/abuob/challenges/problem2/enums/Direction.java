package com.abuob.challenges.problem2.enums;

public enum Direction {
    LEFT('L'),
    RIGHT('R');

    private char abbreviation;

    Direction(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Direction findByAbbreviation(char abbreviation) {
        for (Direction direction : values()) {
            if (direction.getAbbreviation() == abbreviation) {
                return direction;
            }
        }
        throw new IllegalArgumentException("The abbreviation: '" + abbreviation + "' was not found");
    }

    public char getAbbreviation() {
        return abbreviation;
    }
}