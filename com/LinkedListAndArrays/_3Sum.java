package LinkedListAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

    //    Time Complexity : O(n^2)
    //    Space Complexity : O(3*k)  // k is the no.of triplets.

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i <= nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -1 * nums[i];
            int l = i + 1, h = nums.length - 1;
            while(l < h){
                int x = nums[l] + nums[h];
                if(x > target){
                    h--;
                }else if(x < target){
                    l++;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[h]);
                    ans.add(list);
                    while(l < h && nums[l] == nums[l + 1]) l++;
                    while(l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                }
            }
        }
        return ans;
    }
}
