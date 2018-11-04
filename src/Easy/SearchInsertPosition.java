package Easy;

/**
 * @link https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int middle = (first + last + 1) / 2;
            if (nums[middle] < target) {
                first = middle + 1;
            } else if (nums[middle] > target) {
                last = middle - 1;
            } else {
                return middle;
            }
        }
        return first;
    }
}
