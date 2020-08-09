package com.abuob.challenges.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationCheckerTest {

    @Test
    public void test1() {

        PermutationChecker x = new PermutationChecker();
        int[] input = {4, 1, 3};

        int result = x.solution(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test2() {

        PermutationChecker x = new PermutationChecker();
        int[] input = {4, 1, 3, 2};

        int result = x.solution(input);
        assertThat(result).isEqualTo(1);
    }
}
