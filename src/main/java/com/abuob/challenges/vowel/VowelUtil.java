package com.abuob.challenges.vowel;

import java.util.*;
import java.util.stream.Collectors;

public class VowelUtil {

    private static Map<Character, Character> VOWELS = new HashMap();

    static {
        VOWELS.put('a', 'a');
        VOWELS.put('e', 'e');
        VOWELS.put('i', 'i');
        VOWELS.put('o', 'o');
        VOWELS.put('u', 'u');
    }

    public static String vowelsCountString(String s) {

        char[] charArray = s.toLowerCase().toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        Map<Character, Integer> vowelCountMap = new HashMap<>();
        vowelCountMap.put('a', 0);
        vowelCountMap.put('e', 0);
        vowelCountMap.put('i', 0);
        vowelCountMap.put('o', 0);
        vowelCountMap.put('u', 0);

        Integer vowelCount;
        //Count the occurrence each vowel in the input string
        for (char c : charArray) {
            if (isVowel(c)) {
                vowelCount = vowelCountMap.get(c);
                vowelCount++;
                vowelCountMap.put(c, vowelCount);
            }
        }

        //List of all entries in the map
        List<Map.Entry<Character, Integer>> entries =
                new ArrayList<>(vowelCountMap.entrySet());

        //Sort the list by the number of vowels for each with ties sorted alphabetically
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                Character k1 = e1.getKey();
                Character k2 = e2.getKey();
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();

                //Numerical counts are the same, sort by the character ordering, in ascending order
                if (v1.equals(v2)) {
                    return k1.compareTo(k2);
                }
                //Numerical counts different, sort by the number of each character, in descending order
                return v2.compareTo(v1);
            }
        });

        //Remove all the vowel not mentioned in the input string
        entries = entries.stream().filter(characterIntegerEntry -> characterIntegerEntry.getValue() > 0).collect(Collectors.toList());

        Integer entriesSize = entries.size();

        Map.Entry<Character, Integer> entry;
        Character entryVowel;
        Integer entryCount;

        //Display the remaining results to the user
        for (int i = 0; i < entriesSize; i++) {
            entry = entries.get(i);

            entryVowel = entry.getKey();
            entryCount = entry.getValue();

            //Last element of the list so we dont add a new line at the end
            if (i == entriesSize - 1) {
                stringBuffer.append(getDisplayString(entryVowel, entryCount));
            } else {
                stringBuffer.append(getDisplayString(entryVowel, entryCount)).append("\n");
            }
        }
        return stringBuffer.toString();
    }

    private static boolean isVowel(Character character) {
        return VOWELS.containsKey(character);
    }

    private static String getDisplayString(Character c, int numTimes) {
        if (numTimes > 1) {
            return c + " appears " + numTimes + " times";
        }
        return c + " appears 1 time";
    }
}
