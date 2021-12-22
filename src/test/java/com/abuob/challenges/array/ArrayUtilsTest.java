package com.abuob.challenges.array;

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
                .isEqualTo(Lists.newArrayList(1, 3, 7));
    }

    @Test
    public void areArraysEqual_differentSize() {

        int[] intArray1 = new int[]{1, 2, 3};
        int[] intArray2 = new int[]{1, 2, 3, 4};
        assertThat(ArrayUtils.areArraysEqual(intArray1, intArray2)).isFalse();

    }

    @Test
    public void areArraysEqual_sameSize_equal() {

        int[] intArray1 = new int[]{1, 2, 3};
        int[] intArray2 = new int[]{3, 2, 1};
        assertThat(ArrayUtils.areArraysEqual(intArray1, intArray2)).isTrue();

    }

    @Test
    public void areArraysEqual_sameSize_notEqual() {

        int[] intArray1 = new int[]{1, 2, 3};
        int[] intArray2 = new int[]{1, 2, 4};
        assertThat(ArrayUtils.areArraysEqual(intArray1, intArray2)).isFalse();

    }


}
