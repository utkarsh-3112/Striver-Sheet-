package ArraysPartIII;
/*
 *
 * @UtkarshAgarwal
 */


public class SearchInA2dMatrix {
    public static void main(String[] args) {

    }

    // Approach 1 : Brute Force Check All Elements of a matrix
    // Time Complexity : O(N * M)
    // Space Complexity : O(1)


    // Approach 2 : Binary Search Check All Elements of a matrix
    // Time Complexity : O(log(N * M)) if (first element of row > last element of previous row)
    // Time Complexity : O(N * log(M)) above condition not specify
    // Space Complexity : O(1)

    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0 , h = matrix.length - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(matrix[mid][0] > target){
                h = mid - 1;
            }else if(matrix[mid][0] < target){
                l = mid + 1;
            }else
                return true;
        }

        int row = Math.max(h, 0);
        l = 0; h = matrix[0].length - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(matrix[row][mid] > target)
                h = mid - 1;
            else if(matrix[row][mid] < target)
                l = mid + 1;
            else
                return true;
        }
        return false;
    }

    // Approach 3 : Optimized
    // Time Complexity : O(N + M)
    // Space Complexity : O(1)

    public static boolean optimized(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0 , j = m - 1;


        while(i < n && j >= 0 ){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target){ // if element is greater than target than move to previous column
                j--;
            }else{
                i++; // if element is smaller than target than we to next row beacuse previous column contain smaller element
            }
        }
        return false;
    }

    // Approach 4 : Optimized Binary Search on Grid  (if first element of row > last element of previous row without convert into linear array)
    // Time Complexity : O(log(N * M)
    // Space Complexity : O(1)

    public static boolean binarySearchOnGrid(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, h = (m * n) - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            int x = mid / n; // its row
            int y = mid % n; // its column
            if(matrix[x][y] > target){
                h = mid - 1;
            }else if(matrix[x][y] < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
