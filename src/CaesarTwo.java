import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaesarTwo {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";

    public static List<String> encodeStr(String s, int shift) {
        char first = Character.toLowerCase(s.charAt(0));
        char second = LOWER.charAt((LOWER.indexOf(first) + shift) % 26);
        return split("" + first + second + doShift(s, shift, 1), 5);
    }

    public static String decode(List<String> s) {
        String result = String.join("", s);
        int shift = (LOWER.indexOf(result.charAt(1)) - LOWER.indexOf(result.charAt(0))) % 26;
        if (shift < 0) shift += 26;
        return doShift(result.substring(2), shift, -1);
    }

    private static List<String> split(String s, int chunk) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        int size = len / chunk;
        if (len % chunk != 0) size++;
        for (int start = 0; start < len; start += size)
            result.add(s.substring(start, Math.min(len, start + size)));
        return result;
    }

    public static String doShift(String s, int shift, int direction) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .map(c -> {
                    if (!Character.isLetter(c)) return String.valueOf(c);
                    String ref = Character.isUpperCase(c) ? UPPER : LOWER;
                    int newIndex = (shift * direction + ref.indexOf(c)) % 26;
                    if (newIndex < 0) newIndex += 26;
                    return String.valueOf(ref.charAt(newIndex));
                }).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String u = "I should have known that you would have a perfect answer for me!!!";
        System.out.println(encodeStr(u, 77)); // [ihH rgntkc gzu, d jmnvm sgzs x, nt vntkc gzud , z odqedbs zmrv, dq enq ld!!!]
        System.out.println(decode(encodeStr(u, 77))); // I should have known that you would have a perfect answer for me!!!
    }
}
