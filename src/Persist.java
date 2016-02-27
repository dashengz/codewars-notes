public class Persist {
    /**
     * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
     * which is the number of times you must multiply the digits in num until you reach a single digit.
     *
     * @param n The positive parameter num
     * @return The times of the multiplication
     */
    public static int persistence(long n) {
        long a = n / 10;
        int b = (int) n % 10;
        long mult;
        int times = 0;

        if (a == 0) return 0;

        while (a != 0) {
            mult = b;
            while (a != 0) {
                b = (int) a % 10;
                a = a / 10;
                mult *= b;
            }
            a = mult / 10;
            b = (int) mult % 10;
            times++;
        }

        return times;
    }

    public static int persistenceRecursive(long n) {
        long mult = 1, p = n;
        if (p / 10 == 0) return 0;
        for (; p != 0; p /= 10) mult *= p % 10;
        return persistenceRecursive(mult) + 1;
    }

    public static int persistenceString(long n) {
        int times = 0;
        while (n / 10 != 0) {
            n = Long
                    .toString(n)
                    .chars()
                    // take advantage of i - '0' -> its corresponding int value
                    .reduce(1, (r, i) -> r * (i - '0'));
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(persistence(999));
    }
}
