import java.util.stream.IntStream;

public class Max {
    /**
     * Finding the maximum sum of a contiguous subsequence
     * in an array or list of integers
     *
     * @param arr an array of integers
     * @return the maximum sum of a contiguous subsequence
     */
    public static int sequence(int[] arr) {
        int maxSum = 0, thisSum = 0;
        for (int i : arr) {
            thisSum += i;
            if (thisSum > maxSum) maxSum = thisSum;
            else if (thisSum < 0) thisSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{}));
        System.out.println(sequence(IntStream.generate(() -> {
            return (int) (Math.random() * 10 - 5);
        }).limit(1000000).toArray()));
    }
}
