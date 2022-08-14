
/*
 * @UtkarshAgarwal
 *
 */

// Question 4 : Kadane Algorithm

public class KadaneAlgorithm {


    // Approach 1 : Brute Force
    // Time Complexity : O(N ^ 3)
    // Space Complexity : O(1)
    // check every possible length of sub array

    public static int bruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1)
            return nums[0];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }


    // Approach 2 : Better
    // Time Complexity : O(N ^ 2)
    // Space Complexity : O(1)


    public static int better(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curr_sum = 0;
            for (int j = i; j < n; j++) {
                curr_sum += nums[i];
                maxSum = Math.max(maxSum, curr_sum);
            }
        }
        return maxSum;
    }

    // Approach 3 : Optimized
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public int optimized(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i] + currentSum, nums[i]); // it makes max with running array or on its own
            maxSum = Math.max(maxSum, currentSum); // masSun til i
        }
        return maxSum;
    }
}
