package com.ArraysPartII;
/*
 * @UtkarshAgarwal
 *
 */



public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        optimized(matrix);
    }

    // Approach 1 : Brute Force
    // Time Complexity: O(N * N)
    // Space Complexity: O(N * N)
    // copy first row of matrix to last column of the dummy matrix
    public static void bruteForce(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        matrix = rotated;
    }


    // Approach 2 : Better (Transpose then reverse)
    // Time Complexity: O(N*N) + O(N*N) One O(N*N) for transposing the matrix and the other for reversing the matrix.
    // Space Complexity: O(1)

    public static void better(int[][] matrix) {

        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Approach 3 : Optimized
    // Time Complexity: O(N*N) observe the moment of elements of a matrix
    // Space Complexity: O(1)

    public static void optimized(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}