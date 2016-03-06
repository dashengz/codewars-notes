import java.util.TreeSet;

public class DoubleLinear {
    /**
     * The number u(0) = 1 is the first one in u.
     * For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
     * There are no other numbers in u.
     * <p>
     * Ex. u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...] (sorted with <=)
     * <p>
     * Notes:
     * TreeSet provides an implementation of the Set interface that uses a tree for storage.
     * Objects are stored in sorted, ascending order.
     * Access and retrieval times are quite fast, which makes TreeSet an excellent choice
     * when storing large amounts of sorted information that must be found quickly.
     * <p>
     * size(), contains(), first(), last(), remove(), subSet(), tailSet(), iterator()...
     *
     * @param n index of the int in u
     * @return int u(n)
     */
    public static int dblLinear(int n) {
        TreeSet<Integer> u = new TreeSet<>();
        u.add(1);
        for (int i = 0; i < n; i++) {
            int x = u.first();
            int y = x * 2 + 1, z = x * 3 + 1;
            u.add(y);
            u.add(z);
            u.remove(x);
        }
        return u.first();
    }

    public static void main(String[] args) {
        System.out.println(dblLinear(10)); // 22
        System.out.println(dblLinear(20)); // 57
        System.out.println(dblLinear(30)); // 91
        System.out.println(dblLinear(50)); // 175
    }
}
