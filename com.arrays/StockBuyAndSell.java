
/*
 *
 * @UtkarshAgarwal
 */

// Question 4 : Stock Buy And Sell

public class StockBuyAndSell {

    public static void main(String[] args) {
        int ans = optimized(new int[] {7, 1, 5, 3, 6, 4});
    }

    // Approach 1 : Brute Force
    // Time Complexity: O(N ^ 2)
    // Space Complexity: O(1)

    public static int maxProfit(int[] prices) {
        int maxPro = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    maxPro = Math.max(prices[j] - prices[i], maxPro);
                }
            }
        }

        return maxPro;
    }


    // Approach 2 : optimized
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static int optimized(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for(int i = 1;  i < prices.length ; i++){
            if(prices[i] > buy){
                maxProfit = Math.max(maxProfit , prices[i] - buy);
            }else{
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}
