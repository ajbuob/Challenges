package com.abuob.challenges.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayOfWeekCalculatorTest {

    @Test
    public void test1() {
        DayOfWeekCalculator x = new DayOfWeekCalculator();
        String resultDay = x.solution("Tue",2);
        assertThat(resultDay).isEqualTo("Thu");
    }

    @Test
    public void test2() {
        DayOfWeekCalculator x = new DayOfWeekCalculator();
        String resultDay = x.solution("Thu",23);
        assertThat(resultDay).isEqualTo("Sat");
    }
}
