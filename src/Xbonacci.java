import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Xbonacci {
    /**
     * Expanded version of Fibonacci sequence
     *
     * @param signature First x elements in the sequence, the next double should be the sum of the last x elements
     * @param n         The number of elements in the final sequence
     * @return The final sequence
     */
    public static double[] xbonacci(double[] signature, int n) {
        int length = signature.length;
        LinkedList<Double> outputList = new LinkedList<>();
        double sum = 0;
        for (double d : signature) {
            outputList.add(d);
            sum += d;
        }
        outputList.add(sum);
        for (int i = 0; i < n - length - 1; i++) {
            sum += outputList.peekLast() - outputList.get(i);
            outputList.add(sum);
        }
        double[] output = new double[n];
        for (int i = 0; i < n; i++) output[i] = outputList.get(i);
        return output;
    }

    // if uses stream api
    public static double[] xbonacciStream(double[] signature, int n) {
        // use Arrays.copyOf() to initiate a double array that has the signature as elements
        // will fill it with 0 (default value)
        double[] result = Arrays.copyOf(signature, n);
        // starting from after the signature
        for (int i = signature.length; i < n; i++)
            result[i] = IntStream
                    // sum up the previous (signature.length) numbers and map it to the array item
                    .range(i - signature.length, i)
                    .mapToDouble(k -> result[k])
                    .sum();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(xbonacci(new double[]{1, 0, 0, 0, 0, 0, 1}, 20)));
    }
}