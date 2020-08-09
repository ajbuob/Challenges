package com.abuob.challenges.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingIntegerTest {

    @Test
    public void test1() {

        MissingInteger x = new MissingInteger();
        int[] input = {1, 2, 3};

        int result = x.solution(input);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void test2() {

        MissingInteger x = new MissingInteger();
        int[] input = {1,3,6,4,1,2};

        int result = x.solution(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test3() {

        MissingInteger x = new MissingInteger();
        int[] input = {-1,-3};

        int result = x.solution(input);
        assertThat(result).isEqualTo(1);
    }
}
