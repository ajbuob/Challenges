package com.abuob.challenges.problem1;

public final class PangramUtil {

    //Private constructor to prevent object instantiation
    private PangramUtil() {
    }

    /**
     * Utility method to find the missing letters from the input sentence to make it a pangram.
     * This method is case-insensitive (all upper-case letters converted to lower-case) and
     * ignores any non-alphabetic characters.
     *
     * @param input sentence which may or may not contain all letters in the alphabet
     * @return a string containing the missing letters or empty string "" if the input is a pangram
     * @throws IllegalArgumentException if the input is null
     */
    public static String getMissingLetters(final String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input sentence is null");
        }

        StringBuilder missingLetters = new StringBuilder();

        boolean[] letterUsageArray = new boolean[26];
        int usedLetterCount = 0;
        boolean previous;

        //Iterate over input and track the usage of each letter
        for (char c : input.toLowerCase().toCharArray()) {
            //Ignore any character that are not lower-case alphabetical
            if (c >= 'a' && c <= 'z') {
                previous = letterUsageArray[c - 'a'];
                letterUsageArray[c - 'a'] = true;
                //Only increment if the previous value was false
                //(Avoids a double flip if the same letter occurs more than once in the input string)
                if (!previous) {
                    usedLetterCount++;
                }
            }
            //No need to continue if all letters have been found in the input string
            if (usedLetterCount == 26) {
                break;
            }
        }

        //Find the unused characters and add them to the result
        for (int i = 0; i < letterUsageArray.length; ++i) {
            if (!letterUsageArray[i]) {
                missingLetters.append((char) ('a' + i));
            }
        }
        return missingLetters.toString();
    }
}