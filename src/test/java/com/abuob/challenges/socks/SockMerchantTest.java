package com.abuob.challenges.socks;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SockMerchantTest {

    @Test
    public void findNumberOfPairs_NoSocks() {
        assertThat(SockMerchant.findNumberOfPairs(0, new int[]{})).isEqualTo(0);
    }

    @Test
    public void findNumberOfPairs_OneSock() {
        assertThat(SockMerchant.findNumberOfPairs(0, new int[]{5})).isEqualTo(0);
    }

    @Test
    public void findNumberOfPairs_NoPairs() {
        assertThat(SockMerchant.findNumberOfPairs(3, new int[]{10, 20, 15})).isEqualTo(0);
    }

    @Test
    public void findNumberOfPairs_OnePair() {
        assertThat(SockMerchant.findNumberOfPairs(3, new int[]{10, 20, 10})).isEqualTo(1);
    }

    @Test
    public void findNumberOfPairs_OnePairExtra() {
        assertThat(SockMerchant.findNumberOfPairs(3, new int[]{10, 10, 10})).isEqualTo(1);
    }

    @Test
    public void findNumberOfPairs_TwoPairs() {
        assertThat(SockMerchant.findNumberOfPairs(5, new int[]{10, 10, 5, 7, 5})).isEqualTo(2);
    }

    @Test
    public void findNumberOfPairs_ThreePairs() {
        assertThat(SockMerchant.findNumberOfPairs(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20})).isEqualTo(3);
    }

    @Test
    public void findNumberOfPairs_FourPairs() {
        assertThat(SockMerchant.findNumberOfPairs(10, new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3})).isEqualTo(4);
    }
}
