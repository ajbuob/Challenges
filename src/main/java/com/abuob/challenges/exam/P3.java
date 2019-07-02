package com.abuob.challenges.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P3 {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int totalNumberOfBoxes = 0;
        int numberToCarry = 0;
        int numberOfPiles = 0;

        int totalNumberOfPiles = 0;

        //Input validation
        if (input == null || input.length() == 0) {
            System.out.println("check input");
            System.exit(-1);
        }

        String[] inputNums = input.split(" ");

        //Ensure 3 elements in the array
        if (inputNums.length != 3) {
            System.out.println("must enter 3 values");
            System.exit(-1);
        }

        //Input must be numbers and in the bounds of the problem
        try {
            totalNumberOfBoxes = Integer.parseInt(inputNums[0]);
            numberToCarry = Integer.parseInt(inputNums[1]);
            numberOfPiles = Integer.parseInt(inputNums[2]);
        } catch (NumberFormatException nfe) {
            System.out.println("All values must be numbers");
            System.exit(-1);
        }

        if (totalNumberOfBoxes < 1) {
            System.out.println("N must be positive");
            System.exit(-1);
        }

        if (numberToCarry < 1) {
            System.out.println("M must be positive");
            System.exit(-1);
        }

        if (numberOfPiles < 2) {
            System.out.println("P must be greater than 1");
            System.exit(-1);
        }

        List<Integer> numbersToProcess = new ArrayList<>();
        numbersToProcess.add(totalNumberOfBoxes);
        System.out.println(processNumbersList(numbersToProcess, totalNumberOfPiles, numberToCarry, numberOfPiles));
    }

    private static int processNumbersList(List<Integer> inputList, int totalNumberOfPiles,
                                          int numberToCarry, int numberOfPiles) {
        if (inputList.isEmpty()) {
            return totalNumberOfPiles;
        }
        List<Integer> numbersToProcess = new ArrayList<>();
        for(int num: inputList) {

            //Individual pile is small enough to carry
            if(num <= numberToCarry) {
                totalNumberOfPiles ++;
                continue;
            }

            int numPerPile = num / numberOfPiles;
            int remainder = num % numberOfPiles;

            //Add the quotient the correct number of times
            for(int i = 0 ; i<= numPerPile;i++) {
                numbersToProcess.add(numberOfPiles);
            }

            //Check to see if the remainder can be carried or still needs to be further divided
            if(remainder <= numberToCarry) {
                totalNumberOfPiles ++;
            } else {
                numbersToProcess.add(remainder);
            }
        }
        return processNumbersList(numbersToProcess, totalNumberOfPiles, numberToCarry, numberOfPiles);
    }
}
