import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Carboat {
    private static final int BOAT_NUM = 7;
    private static final int BOAT_REMAINDER = 2;
    private static final int CAR_NUM = 9;
    private static final int CAR_REMAINDER = 1;

    /**
     * You have between m to n money to buy boat(7b+2=money) or car(9c+1=money)
     *
     * @param m One of the bound of the possible money
     * @param n Another bound of the possible money
     * @return A string of possible sets of money, boat cost and car cost
     * <p>
     * Example:
     * howmuch(1,1) -> []
     * howmuch(1,100) -> [[M: 37 B: 5 C: 4][M: 100 B: 14 C: 11]]
     * <p>
     * Notes:
     * If build string in loop, better use StringBuilder than string concat
     * <p>
     * -- Trick --
     * Make use of the stream api, specifically int stream
     */
    public static String howmuch(int m, int n) {
        // keep m as the min of the two
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // use StringBuilder to build the end result
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        // start from m, find the money value that fits the criteria until hit n
        for (; m <= n; m++)
            if (m % BOAT_NUM == BOAT_REMAINDER && m % CAR_NUM == CAR_REMAINDER)
                sb.append("[M: ").append(m).append(" B: ").append(m / BOAT_NUM).append(" C: ").append(m / CAR_NUM).append(']');
        return sb.append(']').toString();
    }

    public static String howmuchStream(int m, int n) {
        return "[" + IntStream
                // examine every int from m to n
                .rangeClosed(Math.min(m, n), Math.max(m, n))
                // box to Integer
                .boxed()
                // filter out possible money values
                .filter(i -> i % BOAT_NUM == BOAT_REMAINDER && i % CAR_NUM == CAR_REMAINDER)
                // map the results into the string format
                .map(i -> "[M: " + i + " B: " + i / BOAT_NUM + " C: " + i / CAR_NUM + "]")
                // join the result together
                .collect(Collectors.joining(""))
                + "]";
    }

    public static void main(String[] args) {
        System.out.println(howmuch(1, 100));
        System.out.println(howmuchStream(100, 1));
    }
}
