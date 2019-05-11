package com.abuob.challenges.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);

        String line;
        String lineClean;

        String p1String;
        String p2String;

        Point p1;
        Point p2;

        while ((line = in.readLine()) != null) {
            //Reset point references if multiple lines are being processed
            p1 = null;
            p2 = null;

            //Remove all the whitespace in input so further processing doesnt depend on it
            lineClean = line.replaceAll("\\s", "");

            if (lineClean.indexOf(")") != -1) {
                p1String = lineClean.substring(0, lineClean.indexOf(")") + 1);
                p2String = lineClean.substring(lineClean.indexOf(")") + 1);
                p1 = createPointFromString(p1String);

                if (p1 == null) {
                    //Alert the user and continue to the next line of program input.
                    System.out.println("Bad input - couldn't construct P1 - line:" + line);
                    continue;
                }

                if (p2String == null || p2String.isEmpty()) {
                    //Alert the user and continue to the next line of program input.
                    System.out.println("Bad input - couldn't find P2 - line:" + line);
                    continue;
                }

                p2 = createPointFromString(p2String);

                if (p2 == null) {
                    //Alert the user and continue to the next line of program input.
                    System.out.println("Bad input - couldn't construct P2 - line:" + line);
                    continue;
                }

                //Compute the distance on the valid input
                double distance = distanceBetweenPoints(p1, p2);
                //Typecast double to int as this is the expected output
                System.out.println((int)distance);

            } else {
                //Alert the user and continue to the next line of program input.
                System.out.println("Bad input - couldn't find P1 - line:" + line);
                continue;
            }
        }
    }

    public static Point createPointFromString(String pointStr) {
        //Handle bad input
        if (pointStr == null || pointStr.isEmpty()) {
            return null;
        }

        //Check if a point is really contained in the input string
        if (pointStr.indexOf(")") == -1 || pointStr.indexOf("(") == -1 || pointStr.indexOf(",") == -1) {
            return null;
        }

        String pointStrClean = pointStr.replaceAll("[()]","");
        String [] coordinates = pointStrClean.split(",");

        int xCoordinate = Integer.parseInt(coordinates[0]);
        int yCoordinate = Integer.parseInt(coordinates[1]);

        return new Point(xCoordinate, yCoordinate);
    }

    public static double distanceBetweenPoints(Point p1, Point p2) {
        //Handle bad input appropriately
        if (p1 == null || p2 == null) {
            return 0;
        }

        //Parse off x,y values from the input coordinate points
        int x1 = p1.getX();
        int y1 = p1.getY();

        int x2 = p2.getX();
        int y2 = p2.getY();

        //Distance = √ [(x2-x1)^2 + (y2-y1)^2]
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

class Point {

    private final int x;

    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}