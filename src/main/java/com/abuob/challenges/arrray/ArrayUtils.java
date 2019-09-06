package com.abuob.challenges.arrray;

import java.util.*;

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

    /*
      A zero-indexed array A consisting of N integers is given.
      An equilibrium index of this array is any integer P such that 0 ≤ P < N
      and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.

      A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].

      Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
    */
    public static List<Integer> getEquilibriumIndices(int[] array) {
        List<Integer> answerList = new ArrayList<>();

        long totalSum = sum(array);
        long lowSum = 0L;
        for (int i = 0; i < array.length; i++) {
            totalSum -= array[i];
            if (lowSum == totalSum) {
                answerList.add(i);
            }
            lowSum += array[i];
        }
        return answerList;
    }

    private static long sum(int[] array) {
        return Arrays.stream(array).mapToLong(Long::valueOf).sum();
    }
}
