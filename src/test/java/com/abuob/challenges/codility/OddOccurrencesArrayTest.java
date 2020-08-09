package com.abuob.challenges.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OddOccurrencesArrayTest {

    @Test
    public void test1() {

//        A[0] = 9  A[1] = 3  A[2] = 9
//        A[3] = 3  A[4] = 9  A[5] = 7
//        A[6] = 9
        OddOccurrencesArray x = new OddOccurrencesArray();
        int[] input = {9, 3, 9, 3, 9, 7, 9};

        int result = x.solution(input);
        assertThat(result).isEqualTo(7);

    }

    @Test
    public void test2() {

//        A[0] = 9  A[1] = 3  A[2] = 9
        OddOccurrencesArray x = new OddOccurrencesArray();
        int[] input = {9, 3, 9};

        int result = x.solution(input);
        assertThat(result).isEqualTo(3);

    }
}
