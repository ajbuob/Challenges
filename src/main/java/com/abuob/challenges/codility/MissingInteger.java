package com.abuob.challenges.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//        Given A = [1, 2, 3], the function should return 4.
//
//        Given A = [−1, −3], the function should return 1.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [−1,000,000..1,000,000].

public class MissingInteger {


    public int solution(int[] A) {

        int inputLength = A.length;

        Set<Integer> targetSet = Arrays.stream(A).boxed().collect(Collectors.toSet());
        Set<Integer> filteredSet = targetSet.stream().filter(x -> x > 0).collect(Collectors.toSet());

        System.out.println(targetSet);
        System.out.println(filteredSet);

        if (filteredSet.isEmpty()) {
            return 1;
        }

        for (int i = 1; i < inputLength; i++) {
            if (!filteredSet.contains(i)) {
                return i;
            }
        }
        return Collections.max(targetSet) + 1;
    }
}
