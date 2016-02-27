public class BouncingBall {
    /**
     * Ball thrown from a building, find out how many times it can be seen from a window of the building
     * <p>
     * window < h
     * 0 < bounce < 1
     * <p>
     * Notes:
     * Can also use logarithm to calculate the power (how many times you multiply h * bounce until h < window)
     * 1 + 2 * (int) (Math.floor(Math.log(window / h) / Math.log(bounce)));
     *
     * @param h      height of the building
     * @param bounce rebound ratio
     * @param window distance from the ground
     * @return times the ball is seen from the window (-1 if not seen or condition not met)
     */
    public static int bouncingBall(double h, double bounce, double window) {
        // special cases
        if (window >= h || bounce <= 0 || bounce >= 1 || h <= 0 || window <= 0) return -1;
        // code here
        double newHeight = h * bounce;
        int count = 1;
        while (newHeight > window) {
            newHeight *= bounce;
            count += 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bouncingBall(3.0, 0.66, 1.5)); // 3
        System.out.println(bouncingBall(3.0, 1, 1.5)); // -1
        System.out.println(bouncingBall(30.0, 0.66, 1.5)); // 15
    }
}
