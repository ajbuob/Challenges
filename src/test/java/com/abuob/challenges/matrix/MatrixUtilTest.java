package com.abuob.challenges.matrix;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MatrixUtilTest {

    @Test
    public void test_NullInput() {
        int result = MatrixUtil.findLengthLongestSequence(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_EmptyColumns() {
        int result = MatrixUtil.findLengthLongestSequence(new int[0][]);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_EmptyRows() {
        int result = MatrixUtil.findLengthLongestSequence(new int[3][0]);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_NegativeColumns() {
        assertThatThrownBy(() -> {
            MatrixUtil.findLengthLongestSequence(new int[-5][]);
        }).isInstanceOf(NegativeArraySizeException.class);
    }

    @Test
    public void test_NegativeRows() {
        assertThatThrownBy(() -> {
            MatrixUtil.findLengthLongestSequence(new int[6][-7]);
        }).isInstanceOf(NegativeArraySizeException.class);
    }

    @Test
    public void test_NonSquareMatrix() {
        int[][] matrix = new int[][]{{3, 5}, {2, 4, 1}};

        int result = MatrixUtil.findLengthLongestSequence(matrix);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void test_NegativeNumber() {
        int[][] matrix = new int[][]{{1, 3}, {-2, 4}};

        assertThatThrownBy(() -> {
            MatrixUtil.findLengthLongestSequence(matrix);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The input matrix doesn't contain an increasing sequence");
    }

    @Test
    public void test_DuplicateEntry() {
        int[][] matrix = new int[][]{{1, 3}, {2, 2}};

        assertThatThrownBy(() -> {
            MatrixUtil.findLengthLongestSequence(matrix);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The input matrix doesn't contain an increasing sequence");
    }

    @Test
    public void test_NonPositiveSequence() {
        int[][] matrix = new int[][]{{0, 3}, {1, 2}};

        assertThatThrownBy(() -> {
            MatrixUtil.findLengthLongestSequence(matrix);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The input matrix doesn't contain an increasing sequence");
    }

    @Test
    public void test_SequenceOf5() {
        int[][] matrix = new int[][]{{3, 1, 8}, {4, 5, 2}, {7, 6, 9}};
        int result = MatrixUtil.findLengthLongestSequence(matrix);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test_SequenceOf3Then5() {
        int[][] matrix = new int[][]{{1, 2, 8}, {9, 3, 7}, {4, 5, 6}};
        int result = MatrixUtil.findLengthLongestSequence(matrix);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test_SequenceOf3Then4() {
        int[][] matrix = new int[][]{{2, 3, 1}, {9, 4, 8}, {5, 6, 7}};
        int result = MatrixUtil.findLengthLongestSequence(matrix);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void test_SequenceOf2() {
        int[][] matrix = new int[][]{{1, 2, 7}, {3, 8, 5}, {6, 4, 9}};
        int result = MatrixUtil.findLengthLongestSequence(matrix);
        assertThat(result).isEqualTo(2);
    }
}