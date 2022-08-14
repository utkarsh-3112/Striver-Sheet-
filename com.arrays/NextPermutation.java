/*
 * @UtkarshAgarwal
 *
 */

// Question 2 : Next Permutation

class NextPermutation {
    public static void main(String[] args) {

    }
    // Approach 1 : Brute Force
    // Time complexity : O(n!)O(n!). Total possible permutations is n!n!.
    // Space complexity : O(n)O(n). Since an array will be used to store the permutations.

    // Approach 2 : Optimized
    // find the break point and its greater element from back swap both than reverse the array after break point
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }                                                        //  find break point where 5
                                                                            //           1    4
        if (i >= 0) {                                                       //                  3
            int j = nums.length - 1;                                        //                    2
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}