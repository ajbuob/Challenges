package com.abuob.challenges.hackerrank;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution2Test {

    @Test
    public void oneSecondInCache_noElements() {

        List<Integer> A = List.of(1, 1);

        List<List<Integer>> callLogs = List.of(A);
        List<Integer> result = Solution2.cacheContents(callLogs);

        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactlyElementsOf(List.of(-1));
    }

    @Test
    public void oneSecondInCache_oneElement() {
        List<Integer> A = List.of(1, 1);
        List<Integer> B = List.of(1, 1);
        List<Integer> C = List.of(1, 1);
        List<Integer> D = List.of(1, 1);
        List<Integer> E = List.of(1, 1);

        List<List<Integer>> callLogs = List.of(A, B, C, D, E);
        List<Integer> result = Solution2.cacheContents(callLogs);

        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactlyElementsOf(List.of(1));
    }

    @Test
    public void twoSecondInCache_zeroElement() {
        List<Integer> A = List.of(1, 1);
        List<Integer> B = List.of(1, 1);
        List<Integer> C = List.of(1, 1);
        List<Integer> D = List.of(1, 1);
        List<Integer> E = List.of(1, 1);
        List<Integer> F = List.of(2, 2);
        List<Integer> G = List.of(2, 2);


        List<List<Integer>> callLogs = List.of(A, B, C, D, E, F, G);
        List<Integer> result = Solution2.cacheContents(callLogs);

        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactlyElementsOf(List.of(-1));
    }

    @Test
    public void twoSecondInCache_oneElement() {
        List<Integer> A = List.of(1, 1);
        List<Integer> B = List.of(1, 1);
        List<Integer> C = List.of(1, 1);
        List<Integer> D = List.of(1, 1);
        List<Integer> E = List.of(1, 1);
        List<Integer> F = List.of(1, 1);
        List<Integer> G = List.of(2, 2);
        List<Integer> H = List.of(2, 2);

        List<List<Integer>> callLogs = List.of(A, B, C, D, E, F, G, H);
        List<Integer> result = Solution2.cacheContents(callLogs);

        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactlyElementsOf(List.of(1));
    }

    @Test
    public void threeSecondInCache_inAndOut() {
        List<Integer> A = List.of(1, 1);
        List<Integer> B = List.of(1, 1);
        List<Integer> C = List.of(1, 1);
        List<Integer> D = List.of(1, 1);
        List<Integer> E = List.of(1, 1);
        List<Integer> F = List.of(2, 2);
        List<Integer> G = List.of(2, 2);
        List<Integer> H = List.of(3, 1);

        List<List<Integer>> callLogs = List.of(A, B, C, D, E, F, G, H);
        List<Integer> result = Solution2.cacheContents(callLogs);

        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactlyElementsOf(List.of(1));
    }
}
