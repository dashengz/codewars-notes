import java.util.Arrays;

public class LongestSlideDown {
    /**
     * Imagine that you have a plane pyramid built of numbers, like this one here:
     * /3/
     * \7\ 4
     * 2 \4\ 6
     * 8 5 \9\ 3
     * <p>
     * The 'slide down' is a sum of consecutive numbers from the top to the bottom of the pyramid.
     * In the above case is 3 + 7 + 4 + 9 = 23
     * Write a function longestSlideDown() that takes a pyramid representation as argument and returns its' longest 'slide down'.
     * <p>
     * For example, longestSlideDown([[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]) // => 23
     *
     * @param pyramid the int[][] representation of a pyramid
     * @return the longestSlideDown sum
     */
    public static int longestSlideDown(int[][] pyramid) {
        return pyramid.length != 0 ? merge(pyramid)[0][0] : 0;
    }

    private static int[][] merge(int[][] p) {
        if (p.length == 1) return p;
        for (int i = 0; i < p[p.length - 2].length; i++)
            p[p.length - 2][i] += Math.max(
                    p[p.length - 1][i],
                    p[p.length - 1][i + 1]);
        return merge(Arrays.copyOf(p, p.length - 1));
    }

    public static int longestSlideDownIterative(int[][] p) {
        for (int i = p.length - 1; i >= 1; i--)
            for (int j = 0; j < i; j++)
                p[i - 1][j] += Math.max(p[i][j], p[i][j + 1]);
        return p.length != 0 ? p[0][0] : 0;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };
        System.out.println(longestSlideDown(test)); // 1074
    }
}