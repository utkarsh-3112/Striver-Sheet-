package Array;
/*
 *
 * @UtkarshAgarwal
 */



public class SortAnArrayOf012 {

    public static void main(String[] args) {
        better(new int[] {0, 0, 1, 1, 1, 2, 0, 0, 2});
    }

    // Approach 1 : Brute Force
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    // Sort the Array

    // Approach 2 : Better
    // Time Complexity: O(N) + O(N)
    // Space Complexity: O(1)
    public static void better(int[] nums) {
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            while (colors[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }

    // Approach 3 : Optimized (3 Pointer);
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static void optimized(int[] nums){
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    nums[mid] = nums[low];
                    nums[low] = 0;
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    nums[mid] = nums[high];
                    nums[high] = 2;
                    high--;
                }
            }
        }
    }
}
