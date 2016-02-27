import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
    /**
     * Implement wildcard(s) in the needle.
     * If you have a _ in the needle it will match any character in the haystack.
     * <p>
     * Use java.util.regex.*
     * http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
     * <p>
     * replace _ with . to represent any char
     *
     * @param needle   the target pattern that you need to find
     * @param haystack where to search for the pattern
     * @return the index of the first occurrence that matches the criteria
     */
    public static int find(String needle, String haystack) {
        Matcher m = Pattern
                .compile(Pattern.quote(needle).replace("_", "\\E.\\Q"))
                .matcher(haystack);
        return m.find() ? m.start() : -1;
    }

    public static void main(String[] args) {
        System.out.println(find("strike", "I will strike down upon thee")); // return 7
        System.out.println(find("strike", "That's the good thing about being president")); // return -1
        System.out.println(find("g__d", "That's the good thing about being president")); // return 11
    }
}