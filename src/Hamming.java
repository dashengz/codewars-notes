import java.util.Arrays;
import java.util.TreeSet;

public class Hamming {
    /**
     * Compute the nth smallest hamming number.
     * hamming = 2^a * 3^b * 5^c
     *
     * @param n index of the number (start with 1, not 0)
     * @return the corresponding hamming number
     */
    public static long hamming(int n) {
        if (n <= 0) return -1;
        TreeSet<Long> ts = new TreeSet<>(Arrays.asList(2L, 3L, 5L));
        long smallest = 1;
        for (int i = 1; i < n; i++) {
            smallest = ts.pollFirst();
            ts.add(smallest * 2);
            ts.add(smallest * 3);
            ts.add(smallest * 5);
        }
        return smallest;
    }

    public static void main(String[] args) {
        System.out.println(hamming(1));
        System.out.println(hamming(26));
        System.out.println(hamming(100));
        System.out.println(hamming(5000));
    }
}