package ArraysPartIII;
/*
 *
 * @UtkarshAgarwal
 */

import java.util.HashMap;

// Question : 	Majority Element (>N/2 times)
public class MajorityElement1 {
    public static void main(String[] args) {

    }

    // Approach 1 : Brute Force  Check for (Check the count of occurrences of all elements of the array one by one)
    // Time Complexity : O(N * N)
    // Space Complexity : O(1)

    // Approach 2 : Better
    // Time Complexity: O(N) -> Frequency array or O(N log N) -> HashMap
    // Space Complexity: O(N)

    public static int better(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.replace(num, map.get(num) + 1);
        }
        for(int i : map.keySet()){
            if(map.get(i) > nums.length / 2)
                return i;
        }
        return -1;
    }

    // Approach 3 : Optimized (Moore’s Voting Algorithm)
    // Time Complexity : O(N)
    // Space Complexity : O(1)


    public static int optimized(int[] nums){
        int element = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {                       // If Count is 0 then initialize the current traversing integer of array as Element
                element = num;                      //  If the traversing integer of array and Element are same increase Count by 1
            }                                       // If they are different decrease Count by 1
            if(num==element) count += 1;            // at the end majority element prevails in count
            else count -= 1;
        }
        return element;
    }
}
