package com.abuob.challenges.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int numPrimes = 0;
        int start;
        int stop;

        while ((line = in.readLine()) != null) {

            if (line.indexOf(",") == -1) {
                System.out.println("Not a range of numbers provided - line:" + line);
                continue;
            }

            start = Integer.parseInt(line.substring(0, line.indexOf(",")));
            stop = Integer.parseInt(line.substring(line.indexOf(",") + 1));

            //Check each number (inclusive) to see if it is a prime number
            for (int i = start; i <= stop; ++i) {
                if (isNumberPrime(i)) {
                    numPrimes++;
                }
            }
            System.out.println(numPrimes);
        }
    }

    private static boolean isNumberPrime(int numberToCheck) {
        boolean isFactorFound = false;

        //Check to see if input number is evenly divisible from 2 to n/2
        //as multiplication is communicative (a*b=b*a)
        for (int i = 2; i <= numberToCheck / 2; ++i) {
            if (numberToCheck % i == 0) {
                isFactorFound = true;
                break;
            }
        }
        return !isFactorFound;
    }
}