package com.abuob.challenges.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P2 {

    public static void main(String[] args) throws java.lang.Exception {

        Map<Integer, Integer> countMap = new HashMap<>();
        String majority = "-1";
        int majorityCandidate;
        int majorityFrequency;

        int numElements = 0;
        int[] numsArray = new int[numElements];

        //Read each line
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {

            String nextLine = input.nextLine();

            //Set the number of elements
            if (numElements == 0) {
                try {
                    numElements = Integer.parseInt(nextLine);
                } catch (NumberFormatException nfe) {
                    System.out.println("Check numElements input");
                    System.exit(-1);
                }
                continue;
            }

            //Set the input array
            if (numsArray.length == 0) {
                String[] numsString = nextLine.split(" ");
                numsArray = new int[numElements];

                for (int i = 0; i < numsString.length; i++) {
                    try {
                        numsArray[i] = Integer.parseInt(numsString[i]);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Check numsArray input");
                        System.exit(-1);
                    }
                }
                break;
            }
        }

        if (numElements == 0 || numsArray.length == 0) {
            System.exit(-1);
        }

        //Find the frequency of element in the input array
        for (int num : numsArray) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        //Iterate over count to find the max
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            //Switch if the count is bigger than the current value
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        majorityCandidate = majorityEntry.getKey();
        majorityFrequency = majorityEntry.getValue();

        //Ensure the majority element exists
        if (majorityFrequency > numElements / 2) {
            majority = String.valueOf(majorityCandidate);
        }
        System.out.println(majority);
    }
}
