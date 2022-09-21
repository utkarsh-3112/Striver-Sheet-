package com.Recursion;

import java.util.ArrayList;

public class SubsetSums {

//    Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it.
//    So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).

//    Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        subset(arr, ans, N, 0, 0);
        return ans;
    }

    private static void subset(ArrayList<Integer> arr, ArrayList<Integer> ans, int n, int i, int sum) {
        if(i == n){
            ans.add(sum);
            return;
        }

        subset(arr, ans, n, i + 1, sum + arr.get(i));
        subset(arr, ans, n, i + 1, sum);
    }
}

