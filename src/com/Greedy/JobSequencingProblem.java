package com.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencingProblem {
    static class Job{
        int id;
        int deadline;
        int profit;
    }

    // Approach 1 : using Sorting acc. to profit and nested loops
    // TC : O(N ^ 2)
    // SC : O(N)
    public static int[] approach_1(Job[] arr){
        int n = arr.length;
        int maxDeadline = Integer.MIN_VALUE;
        for(Job x : arr)
            maxDeadline = Math.max(maxDeadline, x.deadline);
        Arrays.sort(arr, (o1, o2) -> o2.profit - o1.profit);
        boolean[] isUsed = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        int jobs = 0;
        int t = maxDeadline;
        for(Job x : arr){
            for(int i = Math.min(t, x.deadline) ; i >= 1 ; i--){
                if(!isUsed[i]){
                    isUsed[i] = true;
                    totalProfit += x.profit;
                    jobs++;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = jobs;
        ans[1] = totalProfit;
        return ans;
    }

    // Approach 2 : Using Priority Queue and sorting acc. to deadline
    // TC : O(NlogN)
    // SC : O(N)

    public static int[] approach_2(Job[] arr){
        Arrays.sort(arr, (o1, o2) -> o1.deadline - o2.deadline);
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        int jobs = 0;
        int totalProfit = 0;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int slots_available;
            if(i == 0)
                slots_available = arr[i].deadline;
            else
                slots_available = arr[i].deadline - arr[i - 1].deadline;

            pq.add(arr[i]);
            while(slots_available > 0 && !pq.isEmpty()){
                Job job = pq.remove();
                jobs++;
                totalProfit += job.profit;
            }
        }
        int[] ans = new int[2];
        ans[0] = jobs;
        ans[1] = totalProfit;
        return ans;
    }
}
