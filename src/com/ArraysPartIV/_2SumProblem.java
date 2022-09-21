package com.ArraysPartIV;
/*
 *
 * @UtkarshAgarwal
 */


import java.util.HashMap;

public class _2SumProblem {
    public static void main(String[] args) {

    }

    // Approach 1 : Brute Force
    // Time Complexity : O(N ^ 2)
    // Space Complexity : O(1)
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return (new int[]{i, j});
            }
        }
        return new int[2];
    }

    // Approach 2 : 2 Pointer Approach (Better)
    // Time Complexity : O(NLogN + O(N))
    // Space Complexity : O(1)

    public static int[] pointerApproach(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int n1 = 0, n2 = 0;
        int[] ans = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {

                n1 = nums[left];
                n2 = nums[right];

                break;

            } else if (nums[left] + nums[right] > target)
                right--;
            else
                left++;
        }

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == n1)
                ans[0] = i;
            else if (nums[i] == n2)
                ans[1] = i;
        }

        return ans;
    }


    // Approach 3 : Hashing (Optimized)
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    public static int[] hashing(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                ans[0] = map.get(target - x);
                ans[1] = i;
                break;
            }else
                map.put(x, i);
        }
        return ans;
    }
}
