import java.math.BigInteger;

public class QuickCalc {
    /**
     * In mathematics the number of k combinations you can have taking from
     * a set of n elements is called the binomial coefficient of n and k, more popularly called n choose k.
     * The formula to compute it is relatively simple:
     * n choose k==n!/(k!*(n-k)!), where ! of course denotes the factorial operator.
     * You are now to create a choose function that computes the binomial coefficient.
     * <p>
     * Be warned: a certain degree of optimization is expected,
     * both to deal with larger numbers precision (and their rounding errors in languages like JS) and computing time.
     *
     * @param n integer to choose from
     * @param p choose how many
     * @return binomial coefficient
     */
    public static BigInteger choose(int n, int p) {
        // math manipulation
        // special cases
        if (n == p) return BigInteger.ONE;
        if (n < p) return BigInteger.ZERO;

        // base case:
        if (p == 0) return BigInteger.ONE;
        // using previous choose results
        return choose(n, p - 1)
                .multiply(BigInteger.valueOf(n - p + 1))
                .divide(BigInteger.valueOf(p));
    }

    public static int chooseInt(int n, int p) {
        // return int using only addition
        // avoiding overflow caused by factorial

        // special cases
        if (n == p) return 1;
        if (n < p) return 0;

        int[] binom = new int[n + 1];
        binom[0] = 1;

        // In-place calc O(n) space
        // According to Pascal's Triangle:
        // n choose p == 1 when p == 0 || n == p
        // n choose p == ((n - 1) choose p) + ((n - 1) choose (p - 1))
        for (int i = 1; i <= n; i++) {
            binom[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                binom[j] += binom[j - 1];
            }
        }

        return binom[p];
    }

    public static void main(String[] args) {
        System.out.println(choose(1, 1)); // 1
        System.out.println(choose(5, 4)); // 5
        System.out.println(choose(10, 5)); // 252
        System.out.println(choose(10, 20)); // 0
        System.out.println(choose(52, 5)); // 2598960
    }
}