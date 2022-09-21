package com.ArraysPartIII;
/*
 *
 * @UtkarshAgarwal
 */

import java.net.PortUnreachableException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

// Question : Majority Elements(>N/3 times) | Find the elements that appears more than N/3 times in the array
public class MajorityElement2 {
    public static void main(String[] args) {

    }

    // Approach 1 : Brute Force  Check for (Check the count of occurrences of all elements of the array one by one)
    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    public static ArrayList< Integer > bruteForce(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == arr[i])
                    cnt++;
            }

            if (cnt > (n / 3))
                ans.add(arr[i]);
        }

        return ans;
    }

    // Approach 2 : Better
    // Time Complexity: O(N) -> Frequency array or O(N log N) -> HashMap
    // Space Complexity: O(N)

    public static ArrayList<Integer> better(int[] arr, int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        for (int x: mp.keySet()) {
            if (mp.get(x) > (n / 3))
                ans.add(x);
        }

        return ans;
    }

    // Approach 3 : Optimized (Extended Boyer Moore’s Voting Algorithm)
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public static ArrayList<Integer> optimized(int[] nums){
        int num1 = -1, num2 = -1 , count1 = 0, count2 = 0;
        for(int num : nums){
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
            else if(count1 == 0){
                count1++;
                num1 = num;
            }else if(count2 == 0){
                count2++;
                num2 = num;
            }else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        count1 = 0; count2 = 0;
        for(int num : nums){
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
        }
        if(count1 > nums.length / 3)
            ans.add(num1);
        if(count2 > nums.length / 3)
            ans.add(num2);
        return ans;
    }
}
