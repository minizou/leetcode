public class Problem35 {
    /** 35. Search Insert Position (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n))
     *      - Space complexity: PO(1)
     * 2. Intuition
     *      - Notably, the array is already sorted. This signals that binary search would probably be a good
     *        idea to use to find an insert position.
     *      - Essentially half of the array is being searched at a time. Calculate the middle between the low
     *        and high index of the given array, and search through a smaller subarray where the new high and low
     *        are determined by where the target is relative to the middle value.
     *      - Return the index once the target is found or if the low value is greater than the high value.
     *
     * @param nums - a sorted array of distinct integers
     * @param target - an integer target value
     * @return the index if the target is found. If not, return the index where it would
     * be if it were inserted in order.
     */

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) { // each iteration it searches half of the previous subarray created by [low,high]
            int mid = (high + low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) { // target found
                return mid;
            }
        }
        return low; // where the target would be if inserted in order
    }
}
