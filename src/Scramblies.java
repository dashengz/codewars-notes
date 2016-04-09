import java.util.HashMap;
import java.util.Map;

public class Scramblies {
    /**
     * See if a portion of str1 characters can be rearranged to match str2
     *
     * @param str1 string #1
     * @param str2 string #2
     * @return true if can, false if can't
     */
    public static boolean scramble(String str1, String str2) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : str2.toCharArray())
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        for (char c : str1.toCharArray())
            if (charMap.get(c) != null) charMap.put(c, charMap.get(c) - 1);
        for (int i : charMap.values())
            if (i > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
        System.out.println(scramble("cedewaraaossoqqyt", "codewars"));
        System.out.println(scramble("katas", "steak"));
    }
}