package com.ArraysPartIV;
/*
 *
 * @UtkarshAgarwal
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    // Approach 1 : Brute Force Sort than count
    // Time Complexity : O(NLogN + O(N))
    // Space Complexity : O(1)

    public static int bruteForce(int[] nums){
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int ans = 1;
        int prev = nums[0]; // previous element
        for(int i = 1; i < nums.length ; i++){
            if(prev + 1 == nums[i]){ // check with previous element
                count++;
            }else if(prev != nums[i]){ // if its not equal with previous make new count
                count = 1;
            }
            prev = nums[i];
            ans = Math.max(ans, count);
        }
        return ans;
    }

    // Approach 2 : Optimized HashSet
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    public static int optimized(int[] nums){
        if(nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)    // Add number to set
            set.add(num);
        int ans = 1;
        for(int num : set){       // iterate through every element of set
            if(!set.contains(num - 1)){  // check its prev exist if not
                int prev = num;         // iterate until its next exist
                int count = 1;
                while(set.contains(prev + 1)){
                    prev += 1;
                    count++;
                }
                ans = Math.max(ans, count); // update ans
            }
        }
        return ans;
    }
}
