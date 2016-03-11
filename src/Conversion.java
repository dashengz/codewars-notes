import java.util.ArrayList;
import java.util.stream.Collectors;

public class Conversion {
    /**
     * Create a function taking a positive integer as its parameter and
     * returning a string containing the Roman Numeral representation of that integer.
     * <p>
     * Symbol    Value
     * I          1
     * V          5
     * X          10
     * L          50
     * C          100
     * D          500
     * M          1,000
     * <p>
     * Provide solution for 1 ~ 3999 (I ~ MMMCMXCIX)
     *
     * @param n positive integer
     * @return roman numeral representation
     */
    public static String solution(int n) {
        if (n < 1 || n > 3999)
            throw new IllegalArgumentException("Please input a positive integer between 1 and 3999 (inclusive).");
        char[] digits = String.valueOf(n).toCharArray();
        ArrayList<String> roman = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            int tens = digits.length - i;
            if (digits[i] == '0') roman.add("");
            else
                switch (tens) {
                    case 1:
                        switch (digits[i]) {
                            case '1':
                                roman.add("I");
                                break;
                            case '2':
                                roman.add("II");
                                break;
                            case '3':
                                roman.add("III");
                                break;
                            case '4':
                                roman.add("IV");
                                break;
                            case '5':
                                roman.add("V");
                                break;
                            case '6':
                                roman.add("VI");
                                break;
                            case '7':
                                roman.add("VII");
                                break;
                            case '8':
                                roman.add("VIII");
                                break;
                            case '9':
                                roman.add("IX");
                                break;
                            default:
                                throw new IllegalArgumentException("Illegal digit detected.");
                        }
                        break;
                    case 2:
                        switch (digits[i]) {
                            case '1':
                                roman.add("X");
                                break;
                            case '2':
                                roman.add("XX");
                                break;
                            case '3':
                                roman.add("XXX");
                                break;
                            case '4':
                                roman.add("XL");
                                break;
                            case '5':
                                roman.add("L");
                                break;
                            case '6':
                                roman.add("LX");
                                break;
                            case '7':
                                roman.add("LXX");
                                break;
                            case '8':
                                roman.add("LXXX");
                                break;
                            case '9':
                                roman.add("XC");
                                break;
                            default:
                                throw new IllegalArgumentException("Illegal digit detected.");
                        }
                        break;
                    case 3:
                        switch (digits[i]) {
                            case '1':
                                roman.add("C");
                                break;
                            case '2':
                                roman.add("CC");
                                break;
                            case '3':
                                roman.add("CCC");
                                break;
                            case '4':
                                roman.add("CD");
                                break;
                            case '5':
                                roman.add("D");
                                break;
                            case '6':
                                roman.add("DC");
                                break;
                            case '7':
                                roman.add("DCC");
                                break;
                            case '8':
                                roman.add("DCCC");
                                break;
                            case '9':
                                roman.add("CM");
                                break;
                            default:
                                throw new IllegalArgumentException("Illegal digit detected.");
                        }
                        break;
                    case 4:
                        switch (digits[i]) {
                            case '1':
                                roman.add("M");
                                break;
                            case '2':
                                roman.add("MM");
                                break;
                            case '3':
                                roman.add("MMM");
                                break;
                            default:
                                throw new IllegalArgumentException("Illegal digit detected.");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal parameter found.");
                }
        }

        return roman.stream().collect(Collectors.joining());
    }

    public static String solutionAlt(int n) {
        if (n < 1 || n > 3999)
            throw new IllegalArgumentException("Please input a positive integer between 1 and 3999 (inclusive).");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (n / 1000); i++) sb.append('M');
        romanify(sb, (n / 100) % 10, 'C', 'D', 'M');
        romanify(sb, (n / 10) % 10, 'X', 'L', 'C');
        romanify(sb, n % 10, 'I', 'V', 'X');
        return sb.toString();
    }

    private static void romanify(StringBuilder sb, int digit, char one, char five, char ten) {
        if (digit < 4)
            for (int i = 0; i < digit; i++) sb.append(one);
        else if (digit == 4)
            sb.append(one).append(five);
        else if (digit < 9) {
            sb.append(five);
            for (int i = 5; i < digit; i++) sb.append(one);
        } else sb.append(one).append(ten);
    }

    public static void main(String[] args) {
        System.out.println(solution(3000)); //should return "M"
        System.out.println(solution(1990)); //should return "MCMXC"
        System.out.println(solution(2008)); //should return "MMVIII"
        System.out.println(solution(1666)); //should return "MDCLXVI"
    }
}