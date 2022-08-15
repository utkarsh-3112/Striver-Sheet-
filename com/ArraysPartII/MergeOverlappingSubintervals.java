package ArraysPartII;
/*
 *
 * @UtkarshAgarwal
 */


import java.util.*;

public class MergeOverlappingSubintervals {
    public static void main(String[] args) {

        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

    }

    // Approach : optimized
    // Time complexity : O(N * logN)
    // Space complexity : O(N)


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> lst = new LinkedList<>();
        int[] temp = intervals[0];
        lst.add(temp);

        for (int[] item : intervals) {
            if (temp[1] >= item[0]) {
                temp[1] = Math.max(temp[1], item[1]);
            } else {
                temp = item;
                lst.add(temp);
            }
        }

        return lst.toArray(new int[lst.size()][]);
    }
}
