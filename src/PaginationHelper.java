import java.util.Arrays;
import java.util.List;

/**
 * Created by Jonathan on 3/4/16.
 * A utility class helpful for querying paging information related to an array.
 */
public class PaginationHelper<I> {
    private int listItemCount = 0;
    private int itemsPerPage = 0;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        listItemCount = collection.size();
        this.itemsPerPage = itemsPerPage;
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount()); //should == 2
        System.out.println(helper.itemCount()); //should == 6
        System.out.println(helper.pageItemCount(0)); //should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); //should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return listItemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (int) Math.ceil((double) listItemCount / itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex > pageCount() - 1) return -1;
        if (listItemCount % itemsPerPage == 0) return itemsPerPage;
        else if (pageIndex == pageCount() - 1) return listItemCount % itemsPerPage;
        else return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        return itemIndex < 0 || itemIndex > listItemCount || listItemCount == 0 ? -1 : itemIndex / itemsPerPage;
    }
}