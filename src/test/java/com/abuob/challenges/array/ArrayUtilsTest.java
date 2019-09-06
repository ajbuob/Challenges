package com.abuob.challenges.array;

import com.abuob.challenges.arrray.ArrayUtils;
import com.google.common.collect.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayUtilsTest {

    @Test
    public void smallestPositiveInteger() {
        assertThat(ArrayUtils.smallestPositiveInteger(new int[]{1, 3, 6, 4, 1, 2})).isEqualTo(5);
        assertThat(ArrayUtils.smallestPositiveInteger(new int[]{1, 2, 3})).isEqualTo(4);
        assertThat(ArrayUtils.smallestPositiveInteger(new int[]{-1, -3})).isEqualTo(1);
    }

    @Test
    public void getEquilibriumIndices() {
        assertThat(ArrayUtils.getEquilibriumIndices(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}))
                .isEqualTo(Lists.newArrayList(1,3,7));
    }
}
