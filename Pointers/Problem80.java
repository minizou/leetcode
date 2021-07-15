public class Problem80 {
    /** 80. Remove Duplicates from Sorted Array II (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using a pointer, iterate through nums, keeping track of when duplicates appear. If a duplicate past
     *        the allowed number of duplicates (i.e., a number appears 3 times when it is only allowed 2), do not
     *        move the pointer. Instead, continue looping through until the next new number is found.
     *      - Shift this new number to be at the pointer, and continue shifting until a not- allowed
     *        number of duplicates is found once more.
     *      - Repeat until finished iterating through nums.
     *
     * @param nums - an integer array sorted in non-decreasing order
     * @return k after placing the final result in the first k slots of nums such that
     * each unique element appears at most twice in-place and in the same sorted order as before
     */

    public int removeDuplicates(int[] nums) {
        int k = 2; // each number appears at most k times
        int count = 1; // current count of how much the current number appeared
        int ptr = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count < k) {
                    nums[ptr++] = nums[i];
                } // ptr doesn't move if duplicate past k limit found
                count++;
            } else { // new number found
                count = 1;
                nums[ptr++] = nums[i];
            }
        }
        return ptr;
    }
}
