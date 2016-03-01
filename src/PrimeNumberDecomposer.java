import java.util.ArrayList;
import java.util.Arrays;

class PrimeNumberDecomposer {
    /**
     * Return value: List of all prime factors of a given number n
     */
    public static Long[] getAllPrimeFactors(long n) {
        // special cases:
        if (n < 0) throw new IllegalArgumentException("Negative number detected!");
        if (n == 0) return new Long[]{};
        if (n == 1) return new Long[]{(long) 1};

        // get a list of all factors
        ArrayList<Long> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++)
            for (; n % i == 0; n /= i)
                factors.add((long) i);
        if (n > 1) factors.add(n);

        return factors.toArray(new Long[factors.size()]);
    }

    /**
     * Return value: List containing two lists, first containing all prime factors without duplicates,
     * second containing the count, how often each prime factor occurred.
     * Return code always contains two lists.
     * <p>
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}} // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[][] getUniquePrimeFactorsWithCount(long n) {
        // special cases:
        if (n == 0) return new Long[][]{{}, {}};

        Long[] allPrime = getAllPrimeFactors(n);
        ArrayList<Long> primes = new ArrayList<>();
        ArrayList<Long> counts = new ArrayList<>();
        primes.add(allPrime[0]);
        long count = 1;
        for (int i = 1; i < allPrime.length; i++) {
            if (allPrime[i].equals(allPrime[i - 1])) count++;
            else {
                primes.add(allPrime[i]);
                counts.add(count);
                count = 1;
            }
        }
        counts.add(count);

        Long[][] res = new Long[2][primes.size()];

        res[0] = primes.toArray(new Long[primes.size()]);
        res[1] = counts.toArray(new Long[counts.size()]);

        return res;
    }

    /**
     * Return value: List containing product of same prime factors,
     * e.g.: 45 = 3*3*5 ==>  {3^2,5^1} == {9,5}
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[] getPrimeFactorPotencies(long n) {
        Long[][] pairs = getUniquePrimeFactorsWithCount(n);
        Long[] res = new Long[pairs[0].length];
        for (int i = 0; i < pairs[0].length; i++)
            res[i] = (long) Math.pow(pairs[0][i], pairs[1][i]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAllPrimeFactors(7775460)));
        System.out.println(Arrays.deepToString(getUniquePrimeFactorsWithCount(7775460)));
        System.out.println(Arrays.toString(getPrimeFactorPotencies(7775460)));
    }
}
