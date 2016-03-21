import java.util.EmptyStackException;
import java.util.Stack;

public class BraceChecker {
    /**
     * Check if the arrangement of the braces is valid or not.
     *
     * @param braces braces that need to be validated
     * @return if the braces are valid
     */
    public static boolean isValid(String braces) {
        Stack<Character> charStack = new Stack<>();
        for (char b : braces.toCharArray()) {
            if (b == '(' || b == '[' || b == '{')
                charStack.push(b);
            else {
                try {
                    char popped = charStack.pop();
                    if (popped == '(' && b != ')'
                            || popped == '[' && b != ']'
                            || popped == '{' && b != '}')
                        return false;
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return charStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}[]")); // true
        System.out.println(isValid("(}")); // false
        System.out.println(isValid("[(])")); // false
        System.out.println(isValid("([{}])")); // true
        System.out.println(isValid("([()[{{}}]{}]")); // false
        System.out.println(isValid("())))))}}}]]]")); // false
    }
}