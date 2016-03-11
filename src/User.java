/**
 * This class simulates the user profile and ranking system that Codewars uses.
 */
public class User {
    public int rank; // rank: -8 ~ 8, excluding 0
    public int progress; // 0 ~ 99, 100 will upgrade the rank

    public User() {
        rank = -8;
        progress = 0;
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.rank); // => -8
        System.out.println(user.progress); // => 0

        user.incProgress(-7);
        System.out.println(user.progress); // => 10

        user.incProgress(-5); // will add 90 progress
        System.out.println(user.progress); // => 0 // progress is now zero
        System.out.println(user.rank); // => -7 // rank was upgraded to -7
    }

    /**
     * Raise the user's progress based on the activity s/he engaged in
     * <p>
     * Rules:
     * two or more lower -> ignore
     * one lower -> 1 point
     * same -> 3 points
     * higher -> (10 * difference * difference) points, eg. two higher 40 points
     *
     * @param r the rank of activity the user engaged in
     */
    public void incProgress(int r) {
        if (r < -8 || r > 8 || r == 0) throw new IllegalArgumentException("Invalid rank!");

        if (r == rank - 1 || r == -1 && rank == 1) progress += 1;
        else if (r == rank) progress += 3;
        else if (r - rank > 0) {
            if (r * rank > 0)
                progress += 10 * (r - rank) * (r - rank);
            else progress += 10 * (r - rank - 1) * (r - rank - 1);
        }

        rank += progress / 100;
        progress -= (progress / 100) * 100;

        if (rank == 0) rank = 1;
        if (rank >= 8) {
            rank = 8;
            progress = 0;
        }
    }
}
