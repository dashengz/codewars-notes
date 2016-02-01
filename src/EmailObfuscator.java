public class EmailObfuscator {
    /**
     * Obfuscate email addresses by converting . and @ to [dot] and [at]
     *
     * @param email The original email address
     * @return The obfuscated email address
     * <p>
     * Notes:
     * <p>
     * If use . as a string, need to escape it "\\."
     * If use . as a char then just do '.'
     * <p>
     * -- Trick --
     * Use replace() consecutively to save time
     */
    public static String obfuscate(String email) {
        // use stringbuilder and append()
        StringBuilder sb = new StringBuilder();
        // iterate through each char of the email
        for (char c : email.toCharArray()) {
            if (c == '.') sb.append(" [dot] ");
            else if (c == '@') sb.append(" [at] ");
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(obfuscate("android.jelly.bean@google.com"));
        System.out.println(System.currentTimeMillis());
    }
}
