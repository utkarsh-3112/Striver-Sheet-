package com.ArraysPartII;
/*
 *
 * @UtkarshAgarwal
 */


public class CountInversionsInAnArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;
        int[] temp = new int[n];
        int ans = mergeSort(arr, temp, 0, arr.length - 1);

    }

    // Time Complexity : O(NLogN)
    // Space Complexity : O(N)

    public static int mergeSort(int[] arr, int[] temp, int l, int h){

        int mid, inv_count = 0;
        if(l < h){
            mid = l + (h - l) / 2;
            inv_count += mergeSort(arr, temp, l, mid);
            inv_count += mergeSort(arr, temp, mid + 1, h);

            inv_count += merge(arr, temp, l, mid + 1, h);
        }
        return inv_count;
    }

    private static int merge(int[] arr, int[] temp, int l, int mid, int h) {
        int i, j, k;
        int inv_count = 0;
        i = l; // i is index for left subarray
        j = mid; // j is index for right subarray
        k = l; // k is index for resultant merged subarray
        while(i <= mid - 1 && j <= h){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];

                /* if(arr[i] > arr[j] it means all elements of left subarray from i to mid
                 * are greater than arr[j] and i < j ans arr[i] > arr[j]
                 * so they are inverse elements.
                 */
                inv_count += mid - i;
            }
        }
        while(i <= mid - 1)
            temp[k++] = arr[i++];
        while (j <= h)
            temp[k++] = arr[j++];
        for (i = l ; i <= h ; i++)
            arr[i] = temp[i];
        return inv_count;

    }
}
