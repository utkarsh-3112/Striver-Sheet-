package com.Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class FractionalKnapsackProblem {


    // TC :  O(n log n + n). O(n log n)
    // SC : O(N)

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> {
            double a = o1.value / (double) o1.weight;
            double b = o2.value / (double) o2.weight;
            return (-1) * Double.compare(a, b);
        });
        Collections.addAll(pq, arr);

        double ans = 0;
        int wt = 0;
        while(!pq.isEmpty() && wt != W){
            Item i = pq.remove();
            int x = Math.min(W - wt, i.weight);
            ans += (x * (i.value / (double) i.weight));
            wt += x;
        }
        return ans;
    }

}


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
