package com.Array;
/*
 * @UtkarshAgarwal
 *
 */



class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        BruteForce(matrix);
        Better(matrix);
        Optimized(matrix);
    }

    // approach 1 : Brute force change elements which are not zero to -1
    // Time Complexity : O(N * M * (N * M ))
    // Space Complexity : O(1)

    public static void BruteForce(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    int x = i + 1;
                    while (x < m) {
                        if (matrix[x][j] != 0)
                            matrix[x][j] = -1;
                        x++;
                    }
                    x = i - 1;
                    while (x >= 0) {
                        if (matrix[x][j] != 0)
                            matrix[x][j] = -1;
                        x--;
                    }
                    x = j + 1;
                    while (x < n) {
                        if (matrix[i][x] != 0)
                            matrix[i][x] = -1;
                        x++;
                    }
                    x = j - 1;
                    while (x >= 0) {
                        if (matrix[i][x] != 0)
                            matrix[i][x] = -1;
                        x--;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0; // convert -1 to 0;
            }
        }
    }

    // Approach 2 : Better
    // Time Complexity : O(N * M +  N * M)
    // Space Complexity : O(N + M)

    public static void Better(int[][] matrix) {
        int m = matrix.length; // there exist 0 for i th row
        int n = matrix[0].length; // there exist 0 for i th column
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        // Traverse the array its row or column is 1 or not
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Approach 3 : Optimized
    // Time Complexity : O(N * M +  N * M)
    // Space Complexity : O(1)

    public static void Optimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1; // to check is zero because of 0th column or not
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }

        // start from end to not change dummy arrays which are 0th row and 0th column
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}