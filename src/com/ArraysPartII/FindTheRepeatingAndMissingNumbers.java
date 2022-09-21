package com.ArraysPartII;
/*
 *
 * @UtkarshAgarwal
 */


public class FindTheRepeatingAndMissingNumbers {
    public static void main(String[] args) {
        xor(new int[] {1, 2, 5, 3, 3});
    }

    // Approach 1 : Brute Force
    // Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int[] bruteForce(int[] nums) {

        int n = nums.length + 1;

        int[] freq = new int[n]; // initializing the substitute array with 0 of size n+1.

        int[] ans = new int[2];  // initializing the answer  array .

        for (int num : nums)
            freq[num]++;

        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 0)
                ans[0] = i;
            else if (freq[i] > 1)
                ans[1] = i;
        }
        return ans;
    }

    // Approach 2 : Optimized (Original Array modified)
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public static int[] optimized(int[] nums) {
        int[] ans = new int[2];
        int sum = (nums.length * (nums.length + 1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums[i] - 1] > 0)
                nums[nums[i] - 1] = -1 * nums[nums[i] - 1];
            else
                ans[1] = nums[i];
            sum -= nums[i];
        }
        sum += ans[1];
        ans[0] = sum;
        return ans;
    }

    // Approach 2 : Optimized (Maths)
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public static int[] maths(int[] nums) {
        long n = nums.length;

        long S = (n * (n + 1)) / 2;           // sum of n terms
        long P = (n * (n + 1) * (2 * n + 1)) / 6; // sum of square of n terms
        long missingNumber = 0, repeating = 0;

        for (int num : nums) {
            S -= (long) num;
            P -= (long) num * (long) num;
        }

        missingNumber = (S + P / S) / 2;

        repeating = missingNumber - S;

        int[] ans = new int[2];
        ans[1] = (int) repeating;
        ans[0] = (int) missingNumber;
        return ans;
    }

    // Approach 4 : Optimized (XOR)
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public static int[] xor(int[] nums){
        int n = nums.length;
        int xor1 = nums[0];  //   Will hold xor of all elements and numbers from 1 to n

        //  Get the xor of all array elements
        for(int i = 1 ; i < n ; i++)
            xor1 = xor1 ^ nums[i];

        //  XOR the previous result with numbers from  1 to n
        for(int i = 1 ; i <= n ; i++)
            xor1 = xor1 ^ i;

        // Get the rightmost set bit in set_bit_no
        int set_bit_no = xor1 & -xor1; // xor & ~(xor - 1) same
        int setBit = Integer.highestOneBit(xor1);

            /* Now divide elements into two sets by comparing
        rightmost set bit of xor1 with the bit at the same
        position in each element. Also, get XORs of two
        sets. The two XORs are the output elements. The
        following two for loops serve the purpose */

        int numWith1 = 0;
        int numWithOut1 = 0;
        for (int num : nums) {
            if ((num & set_bit_no) != 0)   //  arr[i] belongs to first set
                numWith1 = numWith1 ^ num;
            else
                numWithOut1 = numWithOut1 ^ num;  //  arr[i] belongs to second set
        }

        for(int i = 1 ; i <= n ; i++){
            if ((i & set_bit_no) != 0)   //    i belong to first set
                numWith1 = numWith1 ^ i;
            else
                numWithOut1 = numWithOut1 ^ i;  //    i belong to second set


        }

        // at last do a linear check which amont  numWithOut1 and numWith1  is missing or repeating

        // numWithOut1 and numWith1 hold the desired output elements

        int missing , duplicate = 0;
        for (int num : nums) {
            if (num == numWith1 || num == numWithOut1) {
                duplicate = num;
                break;
            }
        }
        missing = xor1 ^ duplicate;
        int[] ans = new int[2];
        ans[0] = missing;
        ans[1] = duplicate;
        return ans;

    }
}
