public class Problem704 {
    /**
     * 704. Binary Search (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Binary search is a search algorithm that takes advantage of when data is already sorted.
     *      - Because it's sorted, binary search cuts the amount of elements to sift through by half in each loop.
     *      - Keep track of the range a target number could possibly be in. Then take the middle value of that
     *        range and check where the target is relative to that value.
     *        - If the target is exactly the middle value, then the target has been found.
     *        - If the target is higher than the middle value, the middle value becomes the low end of the range.
     *        - If the target is lower, then the middle value becomes the high end of the range.
     */

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) { // target is found
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
