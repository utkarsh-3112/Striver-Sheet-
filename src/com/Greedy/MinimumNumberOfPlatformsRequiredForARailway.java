package com.Greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatformsRequiredForARailway {


    // Brute Force
    // TC : O(N ^ 2)

    static int countPlatforms(int n, int[] arr, int[] dep)
    {
        int ans=1; //final value
        for(int i=0;i<=n-1;i++)
        {
            int count=1; // count of overlapping interval of only this   iteration
            for(int j=i+1;j<=n-1;j++)
            {
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
                        (arr[j]>=arr[i] && arr[j]<=dep[i]))
                {
                    count++;
                }
            }
            ans=Math.max(ans,count); //updating the value
        }
        return ans;
    }


    // TC : O(logN)
    // SC : O(1)

    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = 1;
        int curr = 1;
        int i = 1;
        int j = 0;
        while(i < n &&  j < n){
            if(arr[i] <= dep[j]){  //one more platform needed
                curr++;
                i++;
            }else{  //one platform can be reduced
                j++;
                curr--;
            }
            max = Math.max(curr, max);  //updating the value with the current maximum
        }
        return max;
    }

}
