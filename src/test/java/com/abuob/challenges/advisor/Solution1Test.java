package com.abuob.challenges.advisor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution1Test {

    @Test
    public void test1() {

        List input = new ArrayList();
        input.add(5);
        input.add(3);
        input.add(6);
        input.add(7);
        input.add(4);


        Integer result = Solution1.maxTrailing(input);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void test2() {

        List input = new ArrayList();
        input.add(4);
        input.add(3);
        input.add(2);
        input.add(1);

        Integer result =  Solution1.maxTrailing(input);
        assertThat(result).isEqualTo(-1);
    }


}
