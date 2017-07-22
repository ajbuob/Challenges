package com.abuob.challenges.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class AnagramUtil {

    private AnagramUtil() {
    }

    public static boolean isAnagram1(String input1, String input2) {

        String copyOfs1 = input1.replaceAll("\\s", "");
        String copyOfs2 = input2.replaceAll("\\s", "");

        if (copyOfs1.length() != copyOfs2.length()) {
            return false;
        }

        char[] s1Array = copyOfs1.toLowerCase().toCharArray();
        char[] s2Array = copyOfs2.toLowerCase().toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }

    public static boolean isAnagram2(String input1, String input2) {

        String copyOfs1 = input1.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = input2.replaceAll("\\s", "").toLowerCase();

        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {
            return false;
        }


        char[] s1ToArray = copyOfs1.toCharArray();

        for (char c : s1ToArray) {
            int index = copyOfs2.indexOf(c);

            if (index != -1) {
                //If character is present in copyOfs2, removing that char from copyOfs2
                copyOfs2 = copyOfs2.substring(0, index) + copyOfs2.substring(index + 1, copyOfs2.length());
            } else {
                //If character is not present in copyOfs2, setting status as false and breaking the loop
                status = false;
                break;
            }
        }
        return status;
    }

    public static boolean isAnagram3(String input1, String input2) {

        String copyOfs1 = input1.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = input2.replaceAll("\\s", "").toLowerCase();

        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {
            return false;
        }

        char[] s1Array = copyOfs1.toCharArray();
        StringBuilder sb = new StringBuilder(copyOfs2);

        for (char c : s1Array) {
            int index = sb.indexOf(Character.toString(c));

            if (index != -1) {
                //If present, removing that character from sb
                sb = sb.deleteCharAt(index);
            } else {
                //If not present, setting status as false and breaking the loop
                status = false;
                break;
            }
        }
        return status;
    }

    public static boolean isAnagram4(String input1, String input2) {

        String copyOfs1 = input1.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = input2.replaceAll("\\s", "").toLowerCase();

        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < copyOfs1.length(); i++) {
            char charAsKey = copyOfs1.charAt(i);
            int charCountAsValue = 0;

            if (map.containsKey(charAsKey)) {
                charCountAsValue = map.get(charAsKey);
            }

            map.put(charAsKey, ++charCountAsValue);


            charAsKey = copyOfs2.charAt(i);

            charCountAsValue = 0;

            if (map.containsKey(charAsKey)) {
                charCountAsValue = map.get(charAsKey);
            }

            map.put(charAsKey, --charCountAsValue);
        }

        for (int value : map.values()) {
            if (value != 0) {
                //If character count is not equal to 0, then setting status as false
                status = false;
            }
        }
        return status;
    }
}
