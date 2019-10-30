package com.abuob.challenges.strings;

/*
Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.

Given an integer, n, find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the string s='abcac' and n=10, the substring we consider is ,
'abcacabcac' the first 10 characters of her infinite string.
There are 4 occurrences of a in the substring.

Function Description

repeatedString has the following parameter(s):

s: a string to repeat
n: the number of characters to consider


Print a single integer denoting the number of letter a's in the first n letters
of the infinite string created by repeating s infinitely many times.
 */
public class StringRepeatUtil {

    public static long repeatedString(String s, long n) {
        long totalNumCharA = 0;
        int length = s.length();

        long remainderLength;
        String remainderString;

        long numAInString = numCharsInString(s, 'a');

        if (numAInString > 0) {
            //full repeats
            totalNumCharA = (n / length) * numAInString;
            remainderLength = n % length;
            //remainder of last repeat
            if (remainderLength > 0) {
                remainderString = s.substring(0, (int) remainderLength);
                totalNumCharA = totalNumCharA + numCharsInString(remainderString, 'a');
            }
        }
        return totalNumCharA;
    }

    private static int numCharsInString(String s, char c) {
        int numCharsInString = 0;

        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch == c) {
                numCharsInString++;
            }
        }
        return numCharsInString;
    }
}
