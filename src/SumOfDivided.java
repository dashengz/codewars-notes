import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SumOfDivided {
    /**
     * [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
     * <p>
     * eg. I = {12, 15}  result = "(2 12)(3 27)(5 15)"
     *
     * @param l input array
     * @return the formatted sorted String output
     */
    public static String sumOfDivided(int[] l) {
        SortedMap<Integer, Integer> result = new TreeMap<>();
        for (int item : l) {
            int temp = item;
            for (int factor = 2; factor <= temp / factor; factor++) {
                if (temp % factor != 0) continue;
                while (temp % factor == 0) temp /= factor;
                result.put(factor, item + result.getOrDefault(factor, 0));
            }
            if (temp > 1) result.put(temp, item + result.getOrDefault(temp, 0));
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : result.entrySet())
            sb.append(String.format("(%d %d)", entry.getKey(), entry.getValue()));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sumOfDivided(new int[]{12, 15}));
    }
}