package com.ArraysPartII;
import java.util.Arrays;
/*
 *
 * @UtkarshAgarwal
 */

 // Question : Find the duplicate in an array of N+1 integers


public class FindTheDuplicateInAnArrayOfIntegers {
    public static void main(String[] args) {

    }

    // Approach 1 : Frequency
    // Approach 2 :Multiply with -1 to check the duplicate when it gets negative


    // Approach 1 : (Optimized) Floyd's Tortoise and Hare (Cycle Detection)
    // Time Complexity : O(N)
    // Space Complexity : O(1)


    public int FloydTortoiseAndHare(int[] nums) { // Cycle Detection
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
