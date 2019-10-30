package com.abuob.challenges.socks;
/*
John works at a clothing store. He has a large pile of socks that he must pair by color for sale.
Given an array of integers representing the color of each sock, determine how many pairs of socks
with matching colors there are.

For example, there are  socks with colors . There is one pair of color and one of color .
There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below.
It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock

Return the total number of matching pairs of socks that John can sell.
 */


import java.util.Arrays;

public class SockMerchant {

    public static int findNumberOfPairs(int n, int[] ar) {
        int numPairs = 0;

        Arrays.sort(ar);
        int arraySize = ar.length;
        boolean isInPair = false;

        int previous;
        int current;

        for (int i = 1; i < arraySize; i++) {
            if (!isInPair) {
                previous = ar[i - 1];
                current = ar[i];
                if (previous == current) {
                    numPairs++;
                    isInPair = true;
                }
            } else {
                isInPair = false;
            }
        }
        return numPairs;
    }
}
