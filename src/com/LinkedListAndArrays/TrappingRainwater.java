package com.LinkedListAndArrays;

public class TrappingRainwater {

    // TC : O(N * N)
    // SC : O(1)
    // max water above any cell is min of its right max and left max
    public static int bruteForce(int[] arr){
        int n = arr.length;
        int waterTrapped = 0;
        for(int i = 0 ; i < n ; i++){
            int j = i;
            int leftMax = 0, rightMax = 0;
            while(j >= 0){
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while(j < n){
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(rightMax, leftMax) - arr[i];
        }
        return waterTrapped;
    }

    // TC : O(3 * N)
    // SC : O(N) + O(N)
    // just precompute the left max and right max of a cell
    public static int better(int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int waterTrapped = 0;
        prefix[0] = arr[0];
        suffix[n - 1] = arr[n - 1];
        for(int i = 1 ; i < n ; i++){
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        for(int i = n - 2 ; i >= 0 ; i--)
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        for(int i = 0 ; i < n ; i++){
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }

    // TC : O(N)
    // SC : (1)
    // We need a minimum of leftMax and rightMax.So if we take the case when height[l]<=height[r]
    // we increase l++, so we can surely say that there is a block with a height more than height[l]
    // to the right of l. And for the same reason when height[r]<=height[l] we can surely say that
    // there is a block to the left of r which is at least of height[r]. So by traversing these cases
    // and using two pointers approach the time complexity can be decreased without using extra space.
    public static int _2Pointer(int[] arr){
        int n = arr.length;
        int waterTrapped = 0;
        int l = 0, r = n - 1, leftMax = 0, rightMax = 0;
        while(l <= r){

            if(arr[l] <= arr[r]){
                if(arr[l] >= leftMax)
                    leftMax = arr[l];
                else
                    waterTrapped += leftMax - arr[l];
                l++;
            }else{
                if(arr[r] >= rightMax)
                    rightMax = arr[r];
                else
                    waterTrapped += rightMax - arr[r];
                r--;
            }
        }
        return waterTrapped;
    }
}
