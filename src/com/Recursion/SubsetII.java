package com.Recursion;

import java.util.*;

public class SubsetII {


//    Time Complexity: O( 2^n *(k log (x) )). 2^n  for generating every subset and k* log( x)
//    to insert every combination of average length k in a set of size x.After this, we have to convert the set
//    of combinations back into a list of list /vector of vectors which takes more time.

//    Space Complexity:  O(2^n * k) to store every subset of average length k.
//    Since we are initially using a set to store the answer another O(2^n *k) is also used.


    public List<List<Integer>> bruteForce(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int totalSet = (int) Math.pow(2, nums.length) - 1;
        while(totalSet >= 0){
            int x = totalSet;
            List<Integer> subset = new ArrayList<>();
            for(int i = 0 ; i < nums.length ; i++) {
                if ((x & (1 << i)) > 0) subset.add(nums[i]);
            }
            Collections.sort(subset);
            if(!set.contains(subset)){
                set.add(subset);
                ans.add(subset);
            }
            totalSet--;
        }
        return ans;
    }

//    Time Complexity: O(2^n) for generating every subset and O(k)  to
//    insert every subset in another data structure if the average length of every subset is k. Overall O(k * 2^n).

//    Space Complexity: O(2^n * k) to store every subset of average length k.
//    Auxiliary space is O(n)  if n is the depth of the recursion tree.

    public static List<List<Integer>> optimized(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, nums, 0, new ArrayList<Integer>());
        return ans;
    }

    private static void solve(List<List<Integer>> ans, int[] nums, int i, ArrayList<Integer> objects) {
        ans.add(new ArrayList<>(objects));
        for(int j = i ; j < nums.length ; j++){
            if(j > i && nums[j] == nums[j - 1]) continue;
            objects.add(nums[j]);
            solve(ans, nums, j + 1, objects);
            objects.remove(objects.size() - 1);
        }
    }
}
