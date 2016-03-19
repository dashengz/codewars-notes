public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public static void main(String[] args) {
        Dictionary fruits = new Dictionary(
                new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        System.out.println(fruits.findMostSimilar("strawbery")); // must return "strawberry"
        System.out.println(fruits.findMostSimilar("berry")); // must return "cherry"

        Dictionary things = new Dictionary(
                new String[]{"stars", "mars", "wars", "codec", "codewars"});
        System.out.println(things.findMostSimilar("coddwars")); // must return "codewars"

        Dictionary languages = new Dictionary(
                new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        System.out.println(languages.findMostSimilar("heaven")); // must return "java"
        System.out.println(languages.findMostSimilar("javascript")); // must return "javascript" (same words are obviously the most similar ones)
    }

    /**
     * Find the most similar word in the words array
     *
     * @param to the input word
     * @return the most similar word in words array
     */
    public String findMostSimilar(String to) {
        String result = "";
        int distance = Integer.MAX_VALUE;

        for (String w : words) {
            int temp = findDistance(to, w);
            if (temp < distance) {
                distance = temp;
                result = w;
            }
        }
        return result;
    }

    /**
     * Dynamic Programming: Minimum Edit Distance (Levenshtein Distance)
     *
     * @param a word #1
     * @param b word #2
     * @return the minimum edit distance of the two words
     */
    private int findDistance(String a, String b) {
        // initialization
        int[][] table = new int[a.length() + 1][b.length() + 1];
        table[0][0] = 0;
        for (int i = 1; i <= a.length(); i++) table[i][0] = i;
        for (int j = 1; j <= b.length(); j++) table[0][j] = j;

        // bottom up and fill up the table
        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= b.length(); j++)
                table[i][j] = Math.min(Math.min(
                        table[i - 1][j] + 1, // deletion
                        table[i][j - 1] + 1), // insertion
                        table[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1)
                                ? 0 // equal
                                : 1)); // substitution

        return table[a.length()][b.length()];
    }
}