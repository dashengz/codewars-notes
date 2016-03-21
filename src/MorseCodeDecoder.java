import java.util.ArrayList;

public class MorseCodeDecoder {
    /**
     * Morse code in bits representation:
     * 1 -> dot, 111 -> dash,
     * 0 -> in-char pause, 000 -> in-word pause, 0000000 -> between-word pause
     *
     * @param bits a series of 0s and 1s that represents morse code
     * @return the actual morse code
     */
    public static String decodeBits(String bits) {
        // trim starting 0s
        int counter = 0;
        for (; counter < bits.length(); counter++)
            if (bits.toCharArray()[counter] != '0') break;
        bits = bits.substring(counter);
        // add code to list
        ArrayList<ArrayList<Integer>> codeList = new ArrayList<>();
        char code[] = bits.toCharArray();
        counter = 1;
        for (int i = 0; i < code.length; i++)
            if (i != code.length - 1 && code[i] == code[i + 1]) counter++;
            else {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(code[i] - '0');
                pair.add(counter);
                codeList.add(pair);
                counter = 1;
            }
        // trim ending 0s
        if (codeList.get(codeList.size() - 1).get(0) == 0)
            codeList.remove(codeList.size() - 1);
        // find unit
        int k = Integer.MAX_VALUE;
        for (ArrayList<Integer> pair : codeList)
            if (k > pair.get(1)) k = pair.get(1);
        // build code
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> pair : codeList)
            if (pair.get(0) == 1)
                if (pair.get(1) / k == 1) sb.append('.');
                else sb.append('-');
            else if (pair.get(1) / k == 3) sb.append(' ');
            else if (pair.get(1) / k == 7) sb.append("   ");

        return sb.toString();
    }

    /**
     * Decode a string containing morse code (and possibly extra spaces)
     *
     * @param morseCode A string of morse code
     * @return the decoded message
     */
    public static String decode(String morseCode) {
        StringBuilder sb = new StringBuilder();
        String code[] = morseCode.split(" ");
        for (int i = 0; i < code.length; i++)
            if (code[i].length() != 0) sb.append(MorseCode.get(code[i]));
            else if (code[i + 1].length() == 0) sb.append(' ');
        String result = sb.toString();
        int counter = 0;
        for (; counter < result.length(); counter++)
            if (result.toCharArray()[counter] != ' ') break;
        return result.substring(counter);
    }

    public static void main(String[] args) {
        String code = ".... . -.--   .--- ..- -.. .";
        String bits = "110011001100110000001100000011111100110011111100111111" +
                "0000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        System.out.println(decodeBits(bits));
    }

}

// Dummy class
// Serves as the Morse Code Library
class MorseCode {
    public static String get(String code) {
        return "";
    }
}