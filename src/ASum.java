public class ASum {
    /**
     * The parameter of the function findNb will be an integer m
     * you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m
     * if such an n exists or -1 if there is no such n.
     * <p>
     * Note: line 18-19: sum += ++result * result * result;
     *
     * @param m the sum of the cubes
     * @return the integer n specified above
     */
    public static long findNb(long m) {
        if (m < 3) return -1;
        long result = 0, sum = 0;
        while (sum < m) {
            result++;
            sum += result * result * result;
        }
        return m == sum ? result : -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(4183059834009L)); // 2022
        System.out.println(findNb(24723578342962L)); // -1
        System.out.println(findNb(135440716410000L)); // 4824
        System.out.println(findNb(40539911473216L)); // 3568
    }
}