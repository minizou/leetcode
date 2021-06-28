public class Problem26 {
    /** 26. Remove Duplicates from Sorted Array (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(n)
     * 2. Intuition
     *      - Keep track of the last value found and the next index to put the unique elements in.
     *      - If a number does not match the last value found, it is a new unique number. Put this at the next index
     *        and update the last value found and the next free index accordingly.
     *
     * @param nums - an integer array sorted in non-decreasing order
     * @return k after removing the duplicates in-place such that each unique element appears once in the beginning
     * of the array, placing the final result in the first k slots of nums
     */

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; } // case of 0 elements
        int nextIndex = 1;
        int lastNum = nums[0];
        for (int num : nums) {
            if (num != lastNum) { // since it's sorted, not matching means new unique number
                nums[nextIndex] = num;
                lastNum = num;
                nextIndex++;
            }
        }
        return nextIndex;
    }
}
