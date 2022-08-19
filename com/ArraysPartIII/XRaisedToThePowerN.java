package ArraysPartIII;
/*
 *
 * @UtkarshAgarwal
 */

// Question : Pow(x,n)
public class XRaisedToThePowerN {
    public static void main(String[] args) {

    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -1 * N;
        }
        return optimizedRecursive(x, N);

    }

    // Approach 1 : Optimized
    // Time Complexity : O(logN)
    // Space Complexity : O(1)

    public double optimizedRecursive(double x, long n) {
        if (n == 0)
            return 1.0;

        if (n % 2 == 0) {
            double temp = optimizedRecursive(x, n / 2); // make n power by half
            return temp * temp;
        } else {
            double temp = optimizedRecursive(x, (n - 1) / 2); // make n - 1  power by half
            return x * temp * temp; //
        }
    }

    public static double optimizedIterative(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
}

