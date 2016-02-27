import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    /**
     * Given an n*n chess board, return the possible arrangements for n queens,
     * so that they don't attack each other.
     *
     * @param n The board size, and the number of queens
     * @return The list of possible arrangements for queens on the board
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // if n is smaller than 4 then no result
        if (n < 4) return result;

        // initiate the board with dots
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        // solve the n-queen problem
        solve(board, n, 0, result);
        return result;
    }

    private static boolean solve(char[][] board, int n, int col, List<List<String>> result) {
        // able to get one solution
        // add it to the result list
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) list.add(String.valueOf(row));
            result.add(list);
            // return false to backtrack
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, n, i, col)) {
                // greedy
                board[i][col] = 'Q';
                if (solve(board, n, col + 1, result)) return true;
                    // backtrack
                else board[i][col] = '.';
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int n, int row, int col) {
        // each col/row can only hold one queen
        for (int i = 0; i < n; i++) {
            if (board[i][col] != '.') return false;
            if (board[row][i] != '.') return false;
        }

        // check diagonal col after col
        int step = 1;
        // only need to determine if could place queen based on the visited cols
        // greedy
        while (row - step >= 0 && col - step >= 0)
            if (board[row - step][col - step++] != '.') return false;
        step = 1;
        while (row + step < n && col - step >= 0)
            if (board[row + step][col - step++] != '.') return false;

        // safe
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(5));
    }
}