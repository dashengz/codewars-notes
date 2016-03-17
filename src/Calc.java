import java.util.Stack;

public class Calc {
    /**
     * Evaluate expressions in Reverse Polish Notations
     * <p>
     * Empty string -> 0
     * Without space -> invalid
     *
     * @param expr an expression in RPN (no stack underflow / division by zero) (all numbers/operators divided by spaces)
     * @return the result of the expression
     */
    public static double evaluate(String expr) {
        if (expr.length() == 0) return 0;
        Stack<Double> calc = new Stack<>();
        for (String s : expr.split(" "))
            switch (s) {
                case "+":
                    calc.push(calc.pop() + calc.pop());
                    break;
                case "-":
                    calc.push(-1 * calc.pop() + calc.pop());
                    break;
                case "*":
                    calc.push(calc.pop() * calc.pop());
                    break;
                case "/":
                    calc.push(1 / calc.pop() * calc.pop());
                    break;
                default:
                    calc.push(Double.parseDouble(s));
            }
        return calc.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("")); // 0
        System.out.println(evaluate("5.3 1.2 2.6 + 4.4 * + 3.3 -")); // 18.72
        System.out.println(evaluate("1 2 3")); // 3
        System.out.println(evaluate("1 2 3.5")); // 3.5
        System.out.println(evaluate("1 3 +")); // 4
        System.out.println(evaluate("1 3 -")); // -2
        System.out.println(evaluate("1 3 *")); // 3
        System.out.println(evaluate("4 2 /")); // 2
    }
}