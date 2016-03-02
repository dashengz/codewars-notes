import java.math.BigInteger;

public class SumFct {
    /**
     * The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8.
     * It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80
     * Say that S(n) is the nth term of the above sum. So
     * S(0) = 1, S(1) = 1, S(2) = 2, ... , S(5) = 8
     * Could you give the sum S of the perimeters of all the squares in a rectangle
     * when there are n + 1 squares disposed in the same manner as in the drawing:
     * S = S(0) + S(1) + ... + S(n) ?
     *
     * @param n there are n+1 squares whose sides are of Fibonacci sequence
     * @return the total perimeter of the squares
     */
    public static BigInteger perimeter(BigInteger n) {
        // special cases
        if (n.equals(BigInteger.ZERO)) return BigInteger.valueOf(4);
        if (n.equals(BigInteger.ONE)) return BigInteger.valueOf(8);

        BigInteger a = BigInteger.ONE, b = BigInteger.ONE, temp, result = BigInteger.valueOf(8);

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            temp = a.add(b);
            a = b;
            b = temp;
            // b is the side of the nth square
            result = result.add(b.multiply(BigInteger.valueOf(4)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(30)));
    }
}