package Arrays;/*
 * @UtkarshAgarwal
 *
 */



import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {


    public static void main(String[] args) {
        System.out.println(element(2, 2));
        System.out.println(row(4));
    }

    static long[] factorials; // Store factorials from 1 to N

    // Time Complexity : O(N ^ 2)
    // Space Complexity : O(N ^ 2)

    public List<List<Integer>> Solution1(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        ans.add(x);
        for(int i = 2 ; i <= numRows ; i++){
            x = new ArrayList<>();
            x.add(1);
            for(int j = 1 ; j < i - 1 ; j++){
                x.add(ans.get(i - 2).get(i - 1) + ans.get(i - 2).get(i));
            }
            x.add(1);
            ans.add(x);
        }
        return ans;
    }

    // To get given row and col element of a Pascal Triangle
    // Time Complexity : O(N)
    // Space Complexity : O(1)

    public static long element(int n, int m) {
        long element;
        factorials(n); // not relevant use of this function here we need to compute factorial of n only not 1 to N
        element = factorials[n - 1] / ( factorials[m - 1] * factorials[n - m]);
        return element;
    }

    // To get any row of a Pascal Triangle
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    public static ArrayList<Long> row(int n){
        ArrayList<Long> ans = new ArrayList<>();
        factorials(n - 1);
        for(int i = 1 ;i <= n ; i++){
            ans.add(factorials[n - 1] / ( factorials[i - 1] * factorials[n - i]));
        }
        return ans;
    }

    // To compute pre Factorials

    public static void factorials(int n){
        factorials = new long[n + 1];
        factorials[0] = 1;
        for(int i = 1; i <= n ; i++)
            factorials[i] = factorials[i - 1] * i;
    }
}
