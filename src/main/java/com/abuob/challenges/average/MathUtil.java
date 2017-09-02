package com.abuob.challenges.average;

import java.util.Collection;

public final class MathUtil {

    private MathUtil() {
    }

    public static double calculateAverageValue(Collection<Number> input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Input Collection must be have at least one element");

        int numElements = input.size();
        double aveValue = 0.0;

        for (Number n : input) {
            aveValue = aveValue + n.doubleValue();
        }

        return aveValue / numElements;
    }
}