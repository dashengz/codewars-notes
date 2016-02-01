public class Square {
    /**
     * Check if an integer is a square number
     *
     * @param n The integer in question
     * @return boolean if n is a square number or not
     * <p>
     * Notes:
     * Use mod to test if the sqrt result is an integer or not
     * return Math.sqrt(n) % 1 == 0; (shukshuruk, sicknick323, mik0153)
     */
    public static boolean isSquare(int n) {
        // int will discard the decimals
        return Math.sqrt(n) == (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(isSquare(25));
        System.out.println(isSquare(26));
    }
}
