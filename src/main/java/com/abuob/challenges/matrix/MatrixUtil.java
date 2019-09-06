package com.abuob.challenges.matrix;

import java.util.HashMap;
import java.util.Map;

public class MatrixUtil {

    private MatrixUtil() {
    }

    public static int findLengthLongestSequence(int[][] matrix) {
        int numInSequence = 1;
        int maxNumInSequence = 1;
        int entry;
        final int matrixDim;
        final Map<Integer, Coordinate> coordinateSet = new HashMap<>();

        //Check for valid input
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        //Matrix must have the same number of rows and columns
        if (!isSquareMatrix(matrix))
            return -1;

        matrixDim = matrix.length;

        //Fill the Map with the matrix coordinates
        for (int i = 0; i < matrixDim; ++i) {
            for (int j = 0; j < matrixDim; ++j) {
                entry = matrix[i][j];
                //Sequence must be strictly positive integers
                if (entry > 0) {
                    coordinateSet.put(entry, new Coordinate(i, j));
                }
            }
        }

        //Check the set size against the dimension of the matrix
        if (coordinateSet.size() != Math.pow(matrixDim, 2)) {
            throw new IllegalArgumentException("The input matrix doesn't contain an increasing sequence");
        }

        Coordinate current;
        Coordinate next;

        for (int k = 1; k < matrixDim * matrixDim - 1; k++) {

            current = coordinateSet.get(k);
            next = coordinateSet.get(k + 1);

            if (isAdjacent(current, next)) {
                numInSequence++;
            }
            //Reset the counter for the next sequence test
            else {
                numInSequence = 1;
            }

            //Check if a new maximum has been found
            //(The max may occur at the end of the sequence traversal)
            if (numInSequence > maxNumInSequence) {
                maxNumInSequence = numInSequence;
            }
        }
        //The max number of integers in the sequence returned to the caller
        return maxNumInSequence;
    }

    private static boolean isAdjacent(Coordinate c1, Coordinate c2) {
        final int c1x = c1.getX();
        final int c1y = c1.getY();
        final int c2x = c2.getX();
        final int c2y = c2.getY();

        if (c1x == c2x && (c1y == c2y - 1 || c1y == c2y + 1)) {
            return true;
        }
        if (c1y == c2y && (c1x == c2x - 1 || c1x == c2x + 1)) {
            return true;
        }
        return false;
    }

    private static boolean isSquareMatrix(int[][] matrix) {
        int length = matrix.length;

        for (int[] aMatrix : matrix) {
            if (aMatrix.length != length) {
                return false;
            }
        }
        return true;
    }
}