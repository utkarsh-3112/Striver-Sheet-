package LinkedListAndArrays;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
}
