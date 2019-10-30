package com.abuob.challenges.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringRepeatUtilTest {

    @Test
    public void repeatedString_Empty() {
        assertThat(StringRepeatUtil.repeatedString("", 0)).isEqualTo(0);
    }

    @Test
    public void repeatedString_NoAChars() {
        assertThat(StringRepeatUtil.repeatedString("b", 5)).isEqualTo(0);
    }

    @Test
    public void repeatedString_1() {
        assertThat(StringRepeatUtil.repeatedString("a", 1000000000000L)).isEqualTo(1000000000000L);
    }

    @Test
    public void repeatedString_2() {
        assertThat(StringRepeatUtil.repeatedString("ab", 3)).isEqualTo(2);
    }

    @Test
    public void repeatedString_3() {
        assertThat(StringRepeatUtil.repeatedString("ab", 10)).isEqualTo(5);
    }

    @Test
    public void repeatedString_4() {
        assertThat(StringRepeatUtil.repeatedString("aba", 10)).isEqualTo(7);
    }

    @Test
    public void repeatedString_5() {
        assertThat(StringRepeatUtil.repeatedString("abcac", 10)).isEqualTo(4);
    }
}
