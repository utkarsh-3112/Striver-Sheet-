package com.ArraysPartIII;
/*
 *
 * @UtkarshAgarwal
 */


public class GridUniquePaths {

    // Approach 1 : Brute Force (Recursive)
    // Time Complexity : Exponential
    // Space Complexity : Exponential
    // checking all the combinations
    public static int recursive(int i, int j, int m, int n){
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n) return 0;
        return recursive(i + 1, j, m, n) + recursive(i, j + 1, m, n);
    }

    // Approach 2 : Recursive with Dynamic Programming
    //Time Complexity : Quadratic
    // Space Complexity : O(M * N)

     public static int recursiveDP(int i, int j, int m, int n, int[][] dp){
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int x = recursiveDP(i + 1, j, m, n, dp) + recursiveDP(i, j + 1, m, n, dp);
        dp[i][j] = x;
        return x;
     }

    // Approach 3 : Iterative Dynamic Programming
    // Time Complexity : O(N * M)
    // Space Complexity : O(N * M)

    public int optimized(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = m - 1 ; i >= 0 ; i--)
            dp[i][n - 1] = 1;
        for(int i = n - 1; i >= 0 ; i--)
            dp[m - 1][i] = 1;             // initialize dp column and row

        for(int i = m - 2 ; i >= 0 ; i--){
            for(int j = n - 2 ; j >= 0 ; j--){
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]; // now iterate from back take sum of next column and row element
            }
        }
        return dp[0][0];
    }

    // Approach 4 : Combinatorics
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public static int combinatorics(int m, int n){
        int N = n + m - 2; // we have to m - 1 right and n - 1 down to reach the goal so total moves m + n - 2 think
        // Think like we have m + n - 2 boxes we have to put m -1 alike and n - 1 alike so ways of choosing m - 1 boxes from m + n - 2
        int r = m - 1;
        double ans = 1;
        for(int i = 1; i <= r ; i++)
            ans = ans * (N - r + i) / i;

        return (int)ans;
    }
}
