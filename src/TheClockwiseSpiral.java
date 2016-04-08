import java.util.Arrays;

public class TheClockwiseSpiral {
    /**
     * Create a clockwise spiral
     * <p>
     * eg. n = 3 Output: [[1,2,3],[8,9,4],[7,6,5]]
     * <p>
     * 1    2    3
     * 8    9    4
     * 7    6    5
     *
     * @param n the side of the spiral square
     * @return the spiral array
     */
    public static int[][] createSpiral(int n) {
        if (n < 1) return new int[][]{};

        // initialize empty array
        int[][] result = new int[n][n];

        for (int counter = 1, hitUB = n, hitRL = n, row = 0, col = 0; // initialize boundaries
             counter <= n * n; // value
             hitUB--, hitRL--, row++, col++) { // update boundaries after one layer of loop is done
            /* ---------> */
            for (int i = col; i < hitRL; i++)
                result[row][i] = counter++;

            /*          |
                        |
                        v */
            for (int i = row + 1; i < hitUB; i++)
                result[i][hitRL - 1] = counter++;

            /* <--------- */
            for (int i = hitRL - 2; i >= col; i--)
                result[hitUB - 1][i] = counter++;

            /* ^
               |
               |          */
            for (int i = hitUB - 2; i > row; i--)
                result[i][col] = counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createSpiral(3))); // [[1,2,3],[8,9,4],[7,6,5]]
    }
}