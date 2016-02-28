public class DigPow {
    /**
     * Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
     * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
     * If it is the case we will return k, if not return -1.
     * Note: n, p will always be given as strictly positive integers.
     *
     * @param n the positive integer in question
     * @param p start of the successive powers
     * @return the integer k specified above
     */
    public static long digPow(int n, int p) {
        if (n < 1 || p < 1)
            throw new IllegalArgumentException("n and p must be positive integers");
        String nS = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < nS.length(); i++, p++)
            sum += Math.pow(nS.charAt(i) - '0', p);
        return sum % n == 0 ? sum / n : -1;
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1)); // 1
        System.out.println(digPow(92, 1)); // -1
        System.out.println(digPow(695, 2)); // 2
        System.out.println(digPow(46288, 3)); // 51
    }
}
