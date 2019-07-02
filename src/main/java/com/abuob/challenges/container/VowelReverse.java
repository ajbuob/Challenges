package com.abuob.challenges.container;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class VowelReverse {

    private static Map<Character, String> VOWELS = new HashMap();

    public static void main(String[] args) throws java.lang.Exception {
        VOWELS.put('a', "a");
        VOWELS.put('e', "e");
        VOWELS.put('i', "i");
        VOWELS.put('o', "o");
        VOWELS.put('u', "u");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //input check
        if (input == null || input.length() == 0) {
            System.out.println("");
            System.exit(-1);
        }

        char[] charArray = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {

            //Check if left side is a vowel
            if (!isVowel(input.charAt(left))) {
                left++;
                continue;
            }

            //Check if right side is a vowel
            if (!isVowel(input.charAt(right))) {
                right--;
                continue;
            }

            //Both index have a vowel so we can preform the switch
            char tempChar = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tempChar;

            //Increment after switching the characters
            left++;
            right--;
        }

        System.out.println(String.valueOf(charArray));
    }

    private static boolean isVowel(Character character) {
        return VOWELS.containsKey(character);
    }
}
