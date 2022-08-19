package ArraysPartIV;
/*
 *
 * @UtkarshAgarwal
 */


import java.util.HashMap;

public class LargestSubarrayWith0Sum {

    public static void main(String[] args) {
        int x = solve(new int[]{-776,794,387,-648,363,691,764,-539,-171,-210,-566,783,-861,68,930,-21,-68,394,-10,-228,422,785,199,-314,-412,-90,-955,863,-995,306,85,337,847,314,125,583,815,435,-42,-86,-275,-787,-402,755,933,-675,-738,-225,-93,796,-433,-466,98,-316,-651,-300,-285,866,445,441,32,98,482,710,568,-496,587,307,220,-527,733,504,271,-707,341,797,619,847,922,380,-763,-840,-192,-33});
    }

    // Approach 1 : Brute force
    // Time Complexity: O(N^2) as we have two loops for traversal
    // Space Complexity : O(1) as we aren’t using any extra space.

    public static int bruteForce(int[] a){
        int  max = 0;
        for(int i = 0; i < a.length; ++i){
            int sum = 0;
            for(int j = i; j < a.length; ++j){
                sum += a[j];
                if(sum == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }


    // Approach 2 : Optimized using prefix and Hashmap
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    public static int solve(int[] nums){
       int ans = 0;
       int rsum = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0 ; i < nums.length ; i++){
           rsum += nums[i];
           if(rsum == 0)
               ans = i + 1;
           else{
               if(map.containsKey(rsum))
                   ans = Math.max(ans, i - map.get(rsum));
               else
                   map.put(rsum, i);
           }
       }
       return ans;
    }
}
