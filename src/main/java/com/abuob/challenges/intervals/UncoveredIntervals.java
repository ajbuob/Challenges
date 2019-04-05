package com.abuob.challenges.intervals;

import java.util.*;

/*-
 * UncoveredIntervals.java
 *
 * Approach:
 * Sort the input intervals according to their left coordinate.
 *
 * (TreeSet implements SortedSet with add and insert operations O(log n)
 *
 * Once sorted we compare the successive intervals (baseInterval and nextInterval)
 * to see if there exists an uncovered interval between them.
 *
 * 3 possible relationships between baseInterval and nextInterval:
 * 1) nextInterval is fully contained in baseInterval
 * 2) nextInterval intersects baseInterval
 * 3) nextInterval is fully to the right of baseInterval (disjoint - we have found an uncovered interval)
 *
 */
public class UncoveredIntervals {

    public static void main(String[] args) {

        //Input intervals sorted by the left coordinate - add time is 0(log n)
        TreeSet<Interval> inputIntervals = new TreeSet<>(Comparator.comparing(Interval::getLeft));

        //The set of all intervals not covered - add time is O(1)
        Set<Interval> uncoveredIntervals = new HashSet<>();

        //Read each interval
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {

            String nextLine = input.nextLine();
            //Empty String indicates user is done entering intervals
            if (nextLine.equals("")) {
                break;
            }

            //Add each interval to the TreeSet
            Scanner intervalParser = new Scanner(nextLine);
            while (intervalParser.hasNextInt()) {
                //Add is O(log n)
                inputIntervals.add(new Interval(intervalParser.nextInt(), intervalParser.nextInt()));
            }
            intervalParser.close();
        }
        input.close();

        System.out.println("Input Intervals:" + inputIntervals + "\n");

        //Input check
        if (inputIntervals.size() == 1) {
            System.out.println("Please enter more than 1 interval");
            System.exit(0);
        }

        //Starting with the first interval as the baseInterval,
        //iterate over the sorted set to find the uncovered intervals
        Interval baseInterval = inputIntervals.first();
        NavigableSet<Interval> remainingIntervals = inputIntervals.tailSet(baseInterval, false);

        for (Interval currentInterval : remainingIntervals) {
            int baseLeft = baseInterval.getLeft();
            int baseRight = baseInterval.getRight();

            int currentLeft = currentInterval.getLeft();
            int currentRight = currentInterval.getRight();

            //Current is contained inside of the base - move to the next interval
            if (currentLeft <= baseRight && currentRight <= baseRight) {
                //System.out.println("contains - "+ currentInterval + " inside " + baseInterval);
                continue;
            }

            //overlap of intervals - update base to current
            if (currentLeft <= baseRight && currentRight > baseRight) {
                //System.out.println("overlap - baseInterval:" + baseInterval + " currentInterval:" + currentInterval);
                baseInterval = currentInterval;
                continue;
            }

            //Add the uncovered interval to the result set
            if (currentLeft > baseRight) {
                //System.out.println("uncovered - between" + baseInterval + " and " + currentInterval);
                uncoveredIntervals.add(new Interval(baseRight, currentLeft));
                baseInterval = currentInterval;
            }
        }
        System.out.println("\nUncovered Intervals:" + uncoveredIntervals);
    }
}

//Interval class used to model input
class Interval {
    private int left;
    private int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + left + ", " + right + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return left == interval.left &&
                right == interval.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}