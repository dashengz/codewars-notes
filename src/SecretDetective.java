import java.util.ArrayList;
import java.util.stream.Collectors;

public class SecretDetective {
    /**
     * Recover secret string from nplets
     *
     * @param nplets the secret keys
     * @return the secret message
     */
    public static String recoverSecret(char[][] nplets) {
        ArrayList<ArrayList<ArrayList<Character>>> letters = new ArrayList<>();
        ArrayList<ArrayList<Character>> pairs = new ArrayList<>();
        for (char[] ch : nplets)
            for (int i = 0; i < ch.length; i++) {
                ArrayList<Character> pair = new ArrayList<>();
                if (i == 0) {
                    pair.add(' ');
                    pair.add(ch[i]);
                } else {
                    pair.add(ch[i - 1]);
                    pair.add(ch[i]);
                }
                pairs.add(pair);
            }

        pairs.sort((o1, o2) -> {
            if (o1.get(1) > o2.get(1)) return 1;
            else if (o1.get(1) < o2.get(1)) return -1;
            return 0;
        });

        for (int i = 0; i < pairs.size(); i++) {
            if (i == 0 || pairs.get(i).get(1) != letters.get(letters.size() - 1).get(0).get(1)) {
                ArrayList<ArrayList<Character>> letter = new ArrayList<>();
                letter.add(pairs.get(i));
                letters.add(letter);
            } else {
                letters.get(letters.size() - 1).add(pairs.get(i));
            }
        }

        ArrayList<Character> result = new ArrayList<>();
        result.add(' ');
        while (letters.size() != 0) {
            for (int i = 0; i < letters.size(); i++) {
                int sum = 0;
                for (ArrayList<Character> p : letters.get(i))
                    if (!result.contains(p.get(0))) sum++;
                if (sum == 0) {
                    result.add(letters.get(i).get(0).get(1));
                    letters.remove(i);
                } else letters.add(letters.remove(i));
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining()).trim();
    }

    public static void main(String[] args) {
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };
        char[][] quadruplets = {
                {'h', 's', 't', 'o'},
                {'i', 's', 'r', 'y'},
                {'t', 'o', 'r', 'y'},
                {'i', 't', 'o', 'y'},
                {'h', 'i', 't', 'y'}
        };
        System.out.println(recoverSecret(triplets)); // whatisup
        System.out.println(recoverSecret(quadruplets)); // history
    }
}
