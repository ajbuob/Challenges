package com.abuob.challenges.arrray;

import java.util.HashSet;
import java.util.Set;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    //Given an array A of N integers, returns the smallest positive
    //integer (greater than 0) that does not occur in A.
    //
    //A = [1, 3, 6, 4, 1, 2] the function should return 5.
    //A = [1, 2, 3]          the function should return 4.
    //A = [−1, −3]           the function should return 1.
    public static int smallestPositiveInteger(int[] inputArray) {
        int answer = 1;

        int len = inputArray.length;
        Set<Integer> set = new HashSet<>();
        for (int a : inputArray) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= len + 1; i++) {
            if (!set.contains(i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
