import java.util.stream.IntStream;

public class EvenIndex {
    /**
     * Find the index where the left and right sum of an int array are the same
     *
     * @param arr The int array in question
     * @return The target index (returns -1 if no such index exists)
     */
    public static int findEvenIndex1(int[] arr) {
        // caching sums in arrays
        int[] forwardSum = new int[arr.length];
        forwardSum[0] = arr[0];
        int[] backwardSum = new int[arr.length];
        backwardSum[0] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            forwardSum[i] = forwardSum[i - 1] + arr[i];
            backwardSum[i] = backwardSum[i - 1] + arr[arr.length - i - 1];
        }
        for (int i = 0; i < arr.length; i++)
            if (forwardSum[i] == backwardSum[arr.length - i - 1]) return i;
        return -1;
    }

    public static int findEvenIndex2(int[] arr) {
        // Faster way and saves space
        int sumRight = IntStream.of(arr).sum() - arr[0];
        int sumLeft = 0;
        for (int i = 1; i < arr.length; i++) {
            sumLeft += arr[i - 1];
            sumRight -= arr[i];
            if (sumLeft == sumRight) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = IntStream.generate(() -> {
            return (int) (Math.random() * 1000);
        }).limit(1000).toArray();
        System.out.println(findEvenIndex1(ints));
        System.out.println(findEvenIndex2(ints));
    }
}
