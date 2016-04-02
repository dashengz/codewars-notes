import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mixing {
    static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Compare numbers of different lowercase characters between two strings
     * <p>
     * eg.
     * s1 = "Are the kids at home? aaaaa fffff"
     * s2 = "Yes they are here! aaaaa fffff"
     * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
     *
     * @param s1 string #1
     * @param s2 string #2
     * @return the comparison
     */
    public static String mix(String s1, String s2) {
        int s1Array[] = getCount(s1), s2Array[] = getCount(s2);
        List<String> collection = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int one = s1Array[i];
            int two = s2Array[i];
            StringBuilder sb = new StringBuilder();
            if (one > 1 || two > 1) {
                if (one > two) sb.append("1:");
                else if (one < two) sb.append("2:");
                else sb.append("=:");
                for (int j = 0; j < Math.max(one, two); j++)
                    sb.append(LOWERCASE.charAt(i));
                collection.add(sb.toString());
            }
        }
        return collection.stream()
                .sorted((o1, o2) -> {
                    if (o1.length() > o2.length()) return -1;
                    else if (o1.length() < o2.length()) return 1;
                    else if (o1.compareTo(o2) > 0) return 1;
                    else if (o1.compareTo(o2) < 0) return -1;
                    else return 0;
                }).collect(Collectors.joining("/"));
    }

    private static int[] getCount(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            int index = LOWERCASE.indexOf(c);
            if (index != -1) count[index]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(mix("Are the kids at home? aaaaa fffff", "Yes they are here! aaaaa fffff")); // =:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh
        System.out.println(mix(" In many languages", " there's a pair of functions")); // 1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt
    }
}