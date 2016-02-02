import java.util.Arrays;

public class BuyCar {
    /**
     * When can I replace my old car with a new car?
     *
     * @param startPriceOld      Price of the old car
     * @param startPriceNew      Price of the new car
     * @param savingperMonth     Money saved every month
     * @param percentLossByMonth The prices of both cars decrease by this percentage every month,
     *                           and the rate increase by 0.5 percent every two months, starting from the first month
     * @return An int array with the months it'll take, and the money I'll have after I replace the old with the new car
     */
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        if (startPriceOld >= startPriceNew) return new int[]{0, startPriceOld - startPriceNew};
        int month = 1;
        double oldCarPrice = startPriceOld;
        double money = startPriceOld;
        double newPrice = startPriceNew;
        while (money < newPrice) {
            oldCarPrice *= 1 - percentLossByMonth / 100;
            money = oldCarPrice + savingperMonth * month;
            newPrice *= 1 - percentLossByMonth / 100;
            if (month % 2 == 1) percentLossByMonth += 0.5;
            month++;
        }
        return new int[]{month - 1, (int) Math.round(money - newPrice)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nbMonths(2000, 8000, 1000, 1.5)));
    }
}
