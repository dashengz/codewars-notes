public class Thirteen {
    private static final int integers[] = {1, 10, 9, 12, 3, 4}; //pattern

    /**
     * Find the remainder of a long divided by 13 and return the value.
     *
     * @param n The long in question
     * @return The remainder of the long divided by 13
     * <p>
     * Notes:
     * <p>
     * -- Trick --
     * Long.parseLong(String.valueOf(nS.charAt(nS.length() - i - 1)))
     * can be simplified to
     * nS.charAt(nS.length() - i - 1) - '0'
     * <p>
     * -- Trick --
     * n % 10 will get the last digit, and since
     * long will discard the digits after dot,
     * so do n /= 10 to get rid of last digit
     */
    public static long thirt(long n) {
        long a = 0, b = -1;
        // convert long to string
        // for later multiplication
        String nS = "" + n;
        // loop until result becomes stable
        while (b != a) {
            // hold the local result in b
            b = a;
            // reset a
            a = 0;
            // start multiplying
            for (int i = 0; i < nS.length(); i++)
                // multiply and add every digits in a with the integer array
                a += (nS.charAt(nS.length() - i - 1) - '0') * integers[i % 6];
            // reassign nS with a
            nS = "" + a;
        }
        // if b == a, the result becomes stable, return a
        return a;
    }

    public static long thirtRecursive(long n) {
        long a = 0;
        String nS = "" + n;
        for (int i = 0; i < nS.length(); i++)
            a += (nS.charAt(nS.length() - i - 1) - '0') * integers[i % 6];
        // base case
        if (a == n) return a;
        return thirt(a);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(thirt(1234567));
        System.out.println(System.currentTimeMillis());
        System.out.println(thirtRecursive(1234567));
        System.out.println(System.currentTimeMillis());
    }
}
