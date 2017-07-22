package com.abuob.challenges.problem2;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnimatorTest {

    @Test
    public void testAnimateCaseNegativeSpeed() {
        final String EX_MSG = "Speed is negative or initial chamber condition is empty. " +
                "Please check the input and try again";

        assertThatThrownBy(() -> {
            Animator.animate(-4, "..RL..");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EX_MSG);
    }

    @Test
    public void testAnimateCaseNullInit() {
        final String EX_MSG = "Speed is negative or initial chamber condition is empty. " +
                "Please check the input and try again";

        assertThatThrownBy(() -> {
            Animator.animate(1, null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EX_MSG);
    }

    @Test
    public void testAnimateCaseEmptyInit() {
        final String EX_MSG = "Speed is negative or initial chamber condition is empty. " +
                "Please check the input and try again";

        assertThatThrownBy(() -> {
            Animator.animate(1, "");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EX_MSG);
    }

    @Test
    public void testAnimateCase0() {

        List<String> result = Animator.animate(2, "..R....");

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(4);

        //fails if the order of the values are different
        assertThat(result).containsExactly("..X....", "....X..", "......X", ".......");
    }

    @Test
    public void testAnimateCase1() {

        List<String> result = Animator.animate(3, "RR..LRL");

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(4);

        //fails if the order of the values are different
        assertThat(result).containsExactly("XX..XXX",
                ".X.XX..",
                "X.....X",
                ".......");
    }


    @Test
    public void testAnimateCase2() {

        List<String> result = Animator.animate(2, "LRLR.LRLR");

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(5);

        //fails if the order of the values are different
        assertThat(result).containsExactly("XXXX.XXXX",
                "X..X.X..X",
                ".X.X.X.X.",
                ".X.....X.",
                ".........");
    }

    @Test
    public void testAnimateCase3() {

        List<String> result = Animator.animate(10, "RLRLRLRLRL");

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(2);

        //fails if the order of the values are different
        assertThat(result).containsExactly("XXXXXXXXXX",
                "..........");
    }

    @Test
    public void testAnimateCase4() {

        List<String> result = Animator.animate(1, "...");

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);

        //fails if the order of the values are different
        assertThat(result).containsExactly("...");
    }

    @Test
    public void testAnimateCase5() {

        List<String> result = Animator.animate(1, "LRRL.LR.LRR.R.LRRL.");

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(19);

        //fails if the order of the values are different
        assertThat(result).containsExactly("XXXX.XX.XXX.X.XXXX.",
                "..XXX..X..XX.X..XX.",
                ".X.XX.X.X..XX.XX.XX",
                "X.X.XX...X.XXXXX..X",
                ".X..XXX...X..XX.X..",
                "X..X..XX.X.XX.XX.X.",
                "..X....XX..XX..XX.X",
                ".X.....XXXX..X..XX.",
                "X.....X..XX...X..XX",
                ".....X..X.XX...X..X",
                "....X..X...XX...X..",
                "...X..X.....XX...X.",
                "..X..X.......XX...X",
                ".X..X.........XX...",
                "X..X...........XX..",
                "..X.............XX.",
                ".X...............XX",
                "X.................X",
                "...................");
    }
}