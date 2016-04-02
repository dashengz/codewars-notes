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

    public static void main(String[] args) {
        System.out.println(order("a3 Th1is tes4t is2"));
        System.out.println(Arrays.toString(tribonacci(new double[]{1, 1, 1}, 10)));
    }
}