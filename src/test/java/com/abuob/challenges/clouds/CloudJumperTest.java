package com.abuob.challenges.clouds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CloudJumperTest {

    @Test
    public void jumpingOnClouds_Empty() {
        assertThat(CloudJumper.jumpingOnClouds(new int[]{})).isEqualTo(0);
    }

    @Test
    public void jumpingOnClouds_OneElement() {
        assertThat(CloudJumper.jumpingOnClouds(new int[]{0})).isEqualTo(0);
    }


    @Test
    public void jumpingOnClouds_OneJump() {
        assertThat(CloudJumper.jumpingOnClouds(new int[]{0, 0})).isEqualTo(1);
    }

    @Test
    public void jumpingOnClouds_OneJump_Over() {
        assertThat(CloudJumper.jumpingOnClouds(new int[]{0, 1, 0})).isEqualTo(1);
    }

    @Test
    public void jumpingOnClouds_ThreeJump_Success() {
        assertThat(CloudJumper.jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0})).isEqualTo(3);
    }

    @Test
    public void jumpingOnClouds_ThreeJump_Minimum() {
        assertThat(CloudJumper.jumpingOnClouds(new int[]{0, 1, 0, 0, 0, 1, 0})).isEqualTo(3);
    }
}
