package com.abuob.challenges.problem1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PangramUtilTest {

    @Test
    public void testGetMissingLettersNullInput() {
        final String EX_MSG = "Input sentence is null";

        assertThatThrownBy(() -> {
            PangramUtil.getMissingLetters(null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EX_MSG);
    }

    @Test
    public void testGetMissingLettersNoneMissing() {
        final String INPUT = "A quick brown fox jumps over the lazy dog";
        final String OUTPUT = "";
        assertThat(PangramUtil.getMissingLetters(INPUT)).isEqualTo(OUTPUT);
    }

    @Test
    public void testGetMissingLettersWithAllLetters() {
        final String INPUT = "A slow yellow fox crawls under the proactive dog";
        final String OUTPUT = "bjkmqz";
        assertThat(PangramUtil.getMissingLetters(INPUT)).isEqualTo(OUTPUT);
    }

    @Test
    public void testGetMissingLettersWithNonLetters() {
        final String INPUT = "Lions, and tigers, and bears, oh my!";
        final String OUTPUT = "cfjkpquvwxz";
        assertThat(PangramUtil.getMissingLetters(INPUT)).isEqualTo(OUTPUT);
    }

    @Test
    public void testGetMissingLettersAllMissing() {
        final String INPUT = "";
        final String OUTPUT = "abcdefghijklmnopqrstuvwxyz";
        assertThat(PangramUtil.getMissingLetters(INPUT)).isEqualTo(OUTPUT);
    }

}