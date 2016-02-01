import java.util.*;

public class UniqueArray {
    /**
     * UniqueArray.unique([1, 5, 2, 0, 2, -3, 1, 10])
     * -> [1, 5, 2, 0, -3, 10]
     * The position of the input should be retained
     *
     * @param integers The non-unique int array input
     * @return The unique array
     * <p>
     * Notes:
     * take advantage of the stream() api
     * return Arrays.stream(integers).distinct().toArray();
     * <p>
     * If using a hashset, can also use mapToInt()
     * return set.stream().mapToInt(i->i).toArray();
     */
    public static int[] unique(int[] integers) {
        // use ArrayList and contains() method
        ArrayList<Integer> intArray = new ArrayList<>();
        for (Integer integer : integers)
            if (!intArray.contains(integer))
                intArray.add(integer);
        // iterate through the arraylist to get an int array
        int[] uniqueIntegers = new int[intArray.size()];
        int i = 0;
        for (Integer integer : intArray) uniqueIntegers[i++] = integer;
        return uniqueIntegers;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(unique(new int[]{1, 5, 2, 0, 2, -3, 1, 10})));
        System.out.println(System.currentTimeMillis());
    }
}
