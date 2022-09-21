package com.ArraysPartIV;
/*
 *
 * @UtkarshAgarwal
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {

    }

    // Approach 1 : Brute Force
    // Time Complexity : O(N * N)
    // Space Complexity : O(N)

    public static int bruteForce(String s){
        if(s.length() == 0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length() ; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = i ; j < s.length() ; j++){
                if(set.contains(s.charAt(j))){
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                set.add(s.charAt(j));
            }
        }
        return maxans;
    }


    // Approach 2 : Optimized 2 Pointer Approach
    // Time Complexity : O(2 * N) (sometimes left and right both have to travel complete array)
    // Space Complexity : O(N)  where N is the size of HashSet taken for storing the elements

    public static int _2PointerApproach(String s){ // l and r two pointer r check char at r is existed in set or not if yes
        if(s.length() == 0)                        // l move until remove that character then we update its ans
            return 0;
        int maxAns = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int r = 0 ; r < s.length() ; r++){
            if(set.contains(s.charAt(r))){
                while(l < r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            maxAns = Math.max(maxAns, r - l + 1);
            set.add(s.charAt(r));
        }
        return maxAns;
    }

    // Approach 3 : Optimized

    public static int mapApproach(String s) {
        HashMap< Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}


