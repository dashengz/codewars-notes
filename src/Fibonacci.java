import java.math.BigInteger;

/**
 * Calculate Fibonacci number at index n where 1000000 ≤ n ≤ 1500000
 * Handle negative index also, eg. fib(-1) = 1, fib(-2) = -1
 * <p>
 * 1) Matrix Method + Exponentiation by Squaring [O(log(n)) time]
 * 2) Dynamic Programming [O(n) time]
 */
public class Fibonacci {
    /**
     * Calculate Fibonacci number using Matrix Method
     * <p>
     * [1 1]^n  [F(n+1) F(n)]
     * [1 0]  = [F(n) F(n-1)]
     *
     * @param n index of the Fibonacci sequence
     * @return the target Fibonacci number
     */
    public static BigInteger fib(BigInteger n) {
        // handle negative input
        boolean isNegativeAndEven =
                n.compareTo(BigInteger.ZERO) < 0 && n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO);
        n = n.abs();

        // [fib(2)=1 fib(1)=1]
        // [fib(1)=1 fib(0)=0]
        BigInteger[] fibStart = {
                BigInteger.ONE, BigInteger.ONE,
                BigInteger.ONE, BigInteger.ZERO
        };

        // Identity Matrix
        // [1 0]
        // [0 1]
        BigInteger[] result = {
                BigInteger.ONE, BigInteger.ZERO,
                BigInteger.ZERO, BigInteger.ONE
        };

        // exponentiation by squaring
        for (; !n.equals(BigInteger.ZERO); n = n.divide(BigInteger.valueOf(2))) {
            if (!n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
                result = multMatrix(result, fibStart);
            fibStart = multMatrix(fibStart, fibStart);
        }

        return isNegativeAndEven ? result[1].negate() : result[1];
    }

    /**
     * Perform Matrix multiplication (2 * 2 Matrix)
     * [x[0] x[1]]    [y[0] y[1]]
     * [x[2] x[3]]    [y[2] y[3]]
     *
     * @param x First Matrix
     * @param y Second Matrix
     * @return the result (2 * 2 Matrix)
     */
    private static BigInteger[] multMatrix(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[]{
                x[0].multiply(y[0]).add(x[1].multiply(y[2])), x[0].multiply(y[1]).add(x[1].multiply(y[3])),
                x[2].multiply(y[0]).add(x[3].multiply(y[2])), x[2].multiply(y[1]).add(x[3].multiply(y[3]))
        };
    }

    /**
     * Dynamic Programming method (slower than Matrix, faster than recursion)
     */
    public static BigInteger fibDP(BigInteger n) {
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        boolean isNegativeAndEven =
                n.compareTo(BigInteger.ZERO) < 0 && n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO);
        n = n.abs();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = zero.add(one);
            zero = one;
            one = next;
        }
        return isNegativeAndEven ? zero.negate() : zero;
    }

    public static void main(String[] args) {
        System.out.println(fib(BigInteger.valueOf(1299408))); // 72804285...

        System.out.println(fib(BigInteger.valueOf(1))); // 1
        System.out.println(fib(BigInteger.valueOf(-1))); // 1
        System.out.println(fib(BigInteger.valueOf(2))); // 1
        System.out.println(fib(BigInteger.valueOf(-2))); // -1
        System.out.println(fib(BigInteger.valueOf(5))); // 5
        System.out.println(fib(BigInteger.valueOf(-5))); // 5
        System.out.println(fib(BigInteger.valueOf(8))); // 21
        System.out.println(fib(BigInteger.valueOf(-8))); // -21
    }
}