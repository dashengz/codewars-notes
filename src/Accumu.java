public class Accumu {
    /**
     * String manipulation
     * aBcD -> A-Bb-Ccc-Dddd
     *
     * @param s The original string
     * @return The accumulated string
     * <p>
     * Notes:
     * Use StringBuilder to save time
     * <p>
     * -- Trick --
     * ? : operator can return a value so we can use it in a line of code
     * which saves a lot of lines (than using if/else)
     */
    public static String accumSlow(String s) {
        // Naive and slow way
        int length = s.length();
        String out = "";
        for (int i = 0; i < length; i++) {
            String now = s.substring(i, i + 1);
            boolean first = true;
            for (int j = length - i; j <= length; j++) {
                if (first) {
                    out += now.toUpperCase();
                    first = false;
                } else {
                    out += now.toLowerCase();
                }
            }
            out += "-";
        }
        out = out.substring(0, out.length() - 1);
        return out;
    }

    public static String accum(String s) {
        // use stringbuilder and append()
        StringBuilder sb = new StringBuilder();
        // counter i to track which char we are examining
        // also determining how many times a letter should be appended
        int i = 0;
        // iterate through the string
        for (char c : s.toCharArray()) {
            // append '-' only after the first letter
            if (i > 0) sb.append('-');
            // first letter is always upper case
            sb.append(Character.toUpperCase(c));
            // then use for loop and another runner to append the rest of the lowercase letters
            for (int j = 0; j < i; j++)
                sb.append(Character.toLowerCase(c));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(accum("abcdd"));
        System.out.println(System.currentTimeMillis());
        System.out.println(accumSlow("abcdd"));
        System.out.println(System.currentTimeMillis());
    }
}
