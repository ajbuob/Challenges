package com.abuob.challenges.distance;

import com.abuob.challenges.distance.Main;
import com.abuob.challenges.distance.Point;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTester {

    @Test
    public void distance1() {
        Point p1 = new Point(25, 4);
        Point p2 = new Point(1, -6);

        double distance = Main.distanceBetweenPoints(p1,p2);
        assertThat(distance).isEqualTo(26);
    }

    @Test
    public void distance2() {
        Point p1 = new Point(47, 43);
        Point p2 = new Point(-25, -11);

        double distance = Main.distanceBetweenPoints(p1,p2);
        assertThat(distance).isEqualTo(90);
    }
}

