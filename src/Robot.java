import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Robot {
    private static final String[] SYSTEM_WORDS = new String[]{
            "thank", "you", "for", "teaching", "me", "i", "already",
            "know", "the", "word", "do", "not", "understand", "input"
    };
    Set<String> vocab;

    public Robot() {
        vocab = new HashSet<>(Arrays.asList(SYSTEM_WORDS));
    }

    public static void main(String[] args) {
        Robot vicky = new Robot();
        System.out.println(vicky.learnWord("ThanK"));
        System.out.println(vicky.learnWord("abandon"));
        System.out.println(vicky.learnWord("abandon!"));
    }

    public String learnWord(String word) {
        if (word.length() == 0) return "I do not understand the input";
        for (char c : word.toCharArray()) if (!Character.isLetter(c)) return "I do not understand the input";
        if (vocab.contains(word.toLowerCase())) return "I already know the word " + word;
        else {
            vocab.add(word.toLowerCase());
            return "Thank you for teaching me " + word;
        }
    }

    // if uses .matches()
    public String learnWordFormat(String word) {
        if (word.matches("\\A[a-zA-Z]+\\z")) {
            return (vocab.add(word.toLowerCase()) ? "Thank you for teaching me " : "I already know the word ") + word;
        }
        return "I do not understand the input";
    }
}