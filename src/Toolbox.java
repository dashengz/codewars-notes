import java.util.Arrays;
import java.util.stream.IntStream;

public class Toolbox {
    /**
     * Re-order the words in a string according the numbers attached to the words.
     *
     * @param words A string containing words that have a number in each word denoting the correct position in the string
     * @return The string in its correct order
     */
    public static String order(String words) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[9];
        for (String s : words.split(" ")) {
            for (char c : s.toCharArray())
                if (Character.isDigit(c))
                    result[c - '1'] = s;
        }
        for (String s : result) {
            if (s != null) sb.append(s).append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * Alter fibonacci and make it start with a signature of three numbers,
     * and sum up three numbers at a time
     * <p>
     * eg. [0,0,1],1,2,4,7,13,24...
     *
     * @param s the signature (three numbers)
     * @param n the length of the sequence
     * @return the whole sequence
     */
    public static double[] tribonacci(double[] s, int n) {
        double[] result = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++)
            result[i] = IntStream.range(i - 3, i).mapToDouble(k -> result[k]).sum();
        return result;
    }

    /**
     * Sort a string of multiple numbers based on their digit-sums.
     * If two numbers have the same sum, sort them as strings.
     *
     * @param strng the string with unsorted numbers
     * @return the sorted string
     */
    public static String orderWeight(String strng) {
        String weights[] = strng.split(" ");
        Arrays.sort(weights, (o1, o2) -> {
            int s1 = o1.chars().map(k -> k - '0').sum();
            int s2 = o2.chars().map(k -> k - '0').sum();
            return s1 != s2 ? s1 - s2 : o1.compareTo(o2);
        });
        return String.join(" ", (CharSequence[]) weights);
    }

    public static void main(String[] args) {
        // Test for order()
        System.out.println(order("a3 Th1is tes4t is2"));
        // Test for tribonacci()
        System.out.println(Arrays.toString(tribonacci(new double[]{1, 1, 1}, 10)));
        // Test for orderWeight()
        System.out.println(orderWeight("103 123 4444 99 2000")); // 2000 103 123 4444 99
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123")); // 11 11 2000 10003 22 123 1234000 44444444 9999
    }
}