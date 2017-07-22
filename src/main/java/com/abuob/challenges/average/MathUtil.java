package com.abuob.challenges.average;

import java.util.Collection;

public class MathUtil {

    private MathUtil() {
    }

    public static double calculateAverageValue(Collection<Number> input) {
        if (input == null || input.size() == 0)
            throw new IllegalArgumentException("Input Collection must be have at least one element");

        int numElements = input.size();
        double aveValue = 0.0;

        for (Number n : input) {
            aveValue = aveValue + n.doubleValue();
        }

        return aveValue / numElements;
    }
}
