import java.util.ArrayList;

public class PrimeDecomp {
    /**
     * Given a positive number n > 0, find the prime factor decomposition of n.
     * The result will be a string with the following form:
     * "(p1**n1)(p2**n2)...(pk**nk)"
     * with the p(i) in increasing order and n(i) empty if n(i) is 1.
     * Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
     *
     * @param n the target number
     * @return a string that shows the prime factor decomposition of n
     */
    public static String factors(int n) {
        if (n < 2) throw new IllegalArgumentException("A natural number greater than 1 is required!");
        // get a list of all factors
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++)
            for (; n % i == 0; n /= i)
                factors.add(i);
        if (n > 1) factors.add(n);

        // build the string representation of the factor decomposition
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(factors.get(0));
        int count = 1;
        for (int i = 1; i < factors.size(); i++) {
            if (factors.get(i).equals(factors.get(i - 1))) count++;
            else {
                if (count != 1) sb.append("**").append(count);
                sb.append(")(").append(factors.get(i));
                count = 1;
            }
        }
        return count == 1
                ? sb.append(')').toString()
                : sb.append("**").append(count).append(')').toString();
    }

    // merging obtaining decomp with printing result
    public static String factorsMerged(int n) {
        if (n < 2) throw new IllegalArgumentException("A natural number greater than 1 is required!");
        StringBuilder sb = new StringBuilder();
        // condition: factor <= n / factor to reduce unnecessary calc
        for (int factor = 2; factor <= n / factor; factor++) {
            int count;
            for (count = 0; n % factor == 0; count++) n /= factor;
            if (count > 0)
                sb.append('(').append(factor).append(count > 1 ? "**" + count : "").append(')');
        }
        // if the n that failed to pass factor <= n / factor is greater than 1,
        // it must be the last prime that compose the integer, and its count is one
        if (n > 1) sb.append('(').append(n).append(')');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(factors(948640)); // (2**5)(5)(7**2)(11**2)
        System.out.println(factorsMerged(7775460)); // (2**2)(3**3)(5)(7)(11**2)(17)
    }
}