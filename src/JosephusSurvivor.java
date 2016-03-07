import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JosephusSurvivor {
    /**
     * Find the survivor in a Josephus Circle
     *
     * @param n number of people in the circle
     * @param k skip steps
     * @return survivor tag
     */
    public static int josephusSurvivor(final int n, final int k) {
        return n == 1 ? 1 : (josephusSurvivor(n - 1, k) + k - 1) % n + 1;
    }

    /**
     * Find the Josephus Permutation
     *
     * @param items A list of items in the Josephus circle
     * @param k     Skip steps
     * @param <T>   Type of the items
     * @return The permutation
     */
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();
        while (items.size() > 0) {
            for (int i = 0; i < k - 1; i++)
                items.add(items.remove(0));
            result.add(items.remove(0));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(josephusPermutation(new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 2)); // 2, 4, 6, 8, 10, 3, 7, 1, 9, 5
        System.out.println(josephusPermutation(new ArrayList(Arrays.asList("C", "o", "d", "e", "W", "a", "r", "s")), 4)); // "e", "s", "W", "o", "C", "d", "r", "a"

        System.out.println(josephusSurvivor(7, 3)); // 4
        System.out.println(josephusSurvivor(100, 1)); // 100
        System.out.println(josephusSurvivor(40, 3)); // 28
        System.out.println(josephusSurvivor(11, 19)); // 10
    }
}
