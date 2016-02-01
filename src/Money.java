public class Money {
    /**
     * Calculate the year when the desired money is reached
     *
     * @param principal The principal of the investment
     * @param interest  The taxable interest rate
     * @param tax       The tax rate
     * @param desired   The desired amount of money expected
     * @return The year the desired amount is reached
     * <p>
     * Notes:
     * Math advanced alternative
     * return (int) Math.ceil(Math.log(desired / principal) / Math.log(1 + interest * (1 - tax)));
     */
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int year = 0;
        if (principal == desired) return year;
        while (principal <= desired) {
            principal += principal * interest * (1 - tax);
            year++;
        }
        return year;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(calculateYears(1000, 0.05, 0.18, 1100));
        System.out.println(System.currentTimeMillis());
    }
}
