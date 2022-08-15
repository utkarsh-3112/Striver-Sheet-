package ArraysPartII;
/*
 *
 * @UtkarshAgarwal
 */


public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        merge(new int[] {1,2,4,5,6,0},5,new int[] {3}, 1);
    }

    // Approach 1 : Better
    // Time complexity : O(N * M)
    // Space complexity : O(1)

    public static void better(int[] arr1, int[] arr2, int n, int m) {
        // code here
        int i, k;
        for (i = 0; i < n; i++) {
            // take first element from arr1
            // compare it with first element of second array
            // if condition match, then swap
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // then sort the second array
            // put the element in its correct position
            // so that next cycle can swap elements correctly
            int first = arr2[0];
            // insertion sort is used here
            for (k = 1; k < m && arr2[k] < first; k++) {
                arr2[k - 1] = arr2[k];
            }
            arr2[k - 1] = first;
        }
    }

    // Approach 2 : Gap Method
    // Time complexity : O(N + M)
    // Space complexity : O(1)

    public static void gapMethod(int[] arr1, int[] arr2, int n, int m){
        int gap = (int)Math.ceil((n + m) / 2.0);
        while(gap > 0){
            int i = 0;
            int j = gap;
            while(j < (m + n)){
                if(j < n && arr1[i] > arr2[j]){
                    swap(arr1[i], arr1[j]);
                }else if(j >= n && arr1[i] > arr2[j - n]){
                    swap(arr1[i], arr2[j - n]);
                }else if(j >= n && i >= n && arr2[n - i] > arr2[n - j]){
                    swap(arr1[i - n], arr2[j - n]);
                }
                i++;
                j++;
            }
            if(gap == 1)
                gap = 0;
            else
                gap = (int) Math.ceil(gap / 2.0);
        }
    }

    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }


    // Approach 3: Optimized (LeetCode type when nums1 has (m + n) size)
    // Time complexity : O(N + M)
    // Space complexity : O(1)

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        m -= 1;
        n -= 1;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){
                nums1[i--] = nums1[m--];
            }else{
                nums1[i--] = nums2[n--];
            }
        }
        if(n >= 0){
            while(n >= 0)
                nums1[n] = nums2[n--];
        }
    }
}
