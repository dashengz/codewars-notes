import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Anagrams {
    public static BigInteger listPosition(String word) {
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < word.length(); i++) {
            int beforeCount = 0;
            int sameCount = 0;
            TreeSet<Character> beforeCountSet = new TreeSet<>();

            for (int j = i; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j))
                    sameCount++;
                else if (word.charAt(i) > word.charAt(j)) {
                    beforeCount++;
                    beforeCountSet.add(word.charAt(j));
                }
            }

            BigInteger repeatFac = BigInteger.ONE;
            for (char l : beforeCountSet)
                repeatFac = repeatFac.multiply(factorial(countLetter(word.substring(i + 1), l)));

            if (sameCount > 0) repeatFac = repeatFac.multiply(factorial(sameCount));

            result = result.add(
                    factorial(word.length() - i - 1)
                            .multiply(BigInteger.valueOf(beforeCount))
                            .divide(repeatFac)
            );
        }

        return result.add(BigInteger.ONE);
    }

    private static BigInteger factorial(int n) {
        return n == 0
                ? BigInteger.ONE
                : BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    private static int countLetter(String s, char letter) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            if (map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else map.put(c, 1);
        return map.containsKey(letter) ? map.get(letter) : 0;
    }

    public static void main(String[] args) {
        System.out.println(factorial(10)); // 3628800
        System.out.println(countLetter("IMMUNOELECTROPHORETICALLY", 'E')); // 3

        System.out.println(listPosition("ABAB")); // 2
        System.out.println(listPosition("AAAB")); // 1
        System.out.println(listPosition("BAAA")); // 4
        System.out.println(listPosition("QUESTION")); // 24572
        System.out.println(listPosition("BOOKKEEPER")); // 10743

        // TODO: Figure out why longer input doesn't work
        System.out.println(listPosition("IMMUNOELECTROPHORETICALLY"));
        // should be 718393983731145698173, but was 183111614181737640818545
    }
}