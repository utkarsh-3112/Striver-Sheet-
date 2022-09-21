package com.Greedy;

import java.util.Arrays;

public class NMeetingsInOneRoom {

    public static int maxMeetings(int[] start, int[] end, int n)
    {
        Pair[] pairs = new Pair[start.length];
        for(int i = 0 ; i < start.length ; i++)
            pairs[i] = new Pair(i, start[i], end[i]);
        Arrays.sort(pairs);
        int ans = 1;
        int last = pairs[0].e;
        for(int i = 1; i < start.length ; i++){
            if(pairs[i].s > last){
                ans++;
                last = pairs[i].e;
            }
        }
        return ans;
    }
    static class Pair implements Comparable<Pair> {
        int n;
        int s;
        int e;
        Pair(int n, int s, int e){
            this.n = n;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.e < o.e)
                return -1;
            else if (this.e > o.e)
                return 1;
            else if(this.s < o.s)
                return -1;
            return 1;
        }
    }
}
