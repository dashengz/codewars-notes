import java.util.Arrays;
import java.util.stream.LongStream;

public class GapInPrimes {
    /**
     * This function should return the first pair of two prime numbers spaced with a gap of g
     * between the limits m, n if these numbers exist otherwise null.
     *
     * @param g gap
     * @param m start (inclusive)
     * @param n end (inclusive)
     * @return the first pair of prime numbers that fits the criteria
     */
    public static long[] gap(int g, long m, long n) {
        while (m < n) {
            if (isPrime(m) && isPrime(m + g)) {
                boolean isNotGap = false;
                for (long k : LongStream.range(m + 1, m + g).toArray()) {
                    if (isPrime(k)) isNotGap = true;
                }
                if (!isNotGap) return new long[]{m, m + g};
            }
            m += 1;
        }
        return null;
    }

    private static boolean isPrime(long num) {
        for (long i = 2; i < num / i; i++)
            if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(gap(2, 5, 7))); // --> [5, 7]
        System.out.println(Arrays.toString(gap(2, 5, 5))); // --> null
        System.out.println(Arrays.toString(gap(6, 100, 110))); // --> null
        System.out.println(Arrays.toString(gap(4, 130, 200))); // --> [163, 167]
        System.out.println(Arrays.toString(gap(10, 300, 400))); // --> [337, 347]
        System.out.println(Arrays.toString(gap(8, 300, 400))); // --> [359, 367]
    }
}
