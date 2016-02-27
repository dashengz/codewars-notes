public class RevRot {
    /**
     * The input is a string str of digits.
     * Cut the string into chunks of size sz (ignore the last chunk if its size is less than sz).
     * If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse it;
     * otherwise rotate it to the left by one position.
     * Put together these modified chunks and return the result as a string.
     *
     * @param strng A string of digits
     * @param sz    The size of the chunks
     * @return The manipulated string of digits
     */
    public static String revRot(String strng, int sz) {
        // special cases
        if (sz <= 0 || sz > strng.length()) return "";

        strng = strng.substring(0, strng.length() - (strng.length() % sz));

        String[] chunks = strng.split("(?<=\\G.{" + sz + "})");

        for (int i = 0; i < chunks.length; i++) {
            chunks[i] = chunks[i].chars().map(k -> k * k * k).sum() % 2 == 0
                    ? (new StringBuilder(chunks[i])).reverse().toString()
                    : (new StringBuilder(chunks[i])).append(chunks[i].charAt(0)).deleteCharAt(0).toString();
        }

        return String.join("", chunks);
    }

    public static void main(String[] args) {
        System.out.println(revRot("123456987654", 6)); // --> "234561876549"
        System.out.println(revRot("123456987653", 6)); // --> "234561356789"
        System.out.println(revRot("66443875", 4)); // --> "44668753"
        System.out.println(revRot("66443875", 8)); // --> "64438756"
        System.out.println(revRot("664438769", 8)); // --> "67834466"
        System.out.println(revRot("123456779", 8)); // --> "23456771"
        System.out.println(revRot("", 8)); // --> ""
        System.out.println(revRot("123456779", 0)); // --> ""
    }
}
