package com.ArraysPartIV;
/*
 *
 * @UtkarshAgarwal
 */


import java.util.HashMap;

public class CountTheNumberOfSubarraysWithGivenXorK {
    public static void main(String[] args) {

    }

    // Brute Force check every subarray possible iterating from first to last than choose second than to last


    // Approach 2 : Optimized using prefix
    //  Time Complexity: O(N)
    // Space Complexity: O(N)

    /* suppose we have xor any prefix subarray x to make there exist subarray of xor k if any previous subarray contains x ^ k it
     * means we can get subarray whose xor is k
     *
     */
    public static int optimized(int[] nums, int k){
        int xorr = 0;
        int count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            xorr = xorr ^ num;
            if (map.containsKey(xorr ^ k)) {
                count += map.get(xorr ^ k);
            }
            if (xorr == k)
                count++;
            if (map.containsKey(xorr))
                map.replace(xorr, map.get(xorr) + 1);
            else
                map.put(xorr, 1);
        }
        return count;
    }
}
