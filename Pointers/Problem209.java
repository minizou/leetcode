public class Problem209 {
    /**
     * 209. Minimum Size Subarray Sum (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using 2 pointers similarly to a sliding window approach, loop through nums until the target is
     *        reached. When it is reached, a valid subarray is found.
     *      - Compare this subarray length to any previous subarray lengths and continue this process by
     *        accessing the next possible subarray (starting at the next int in nums) by moving the slow
     *        pointer. Adjust target's value accordingly.
     *
     * @param target - an integer to reach
     * @param nums - an array of positive integers
     * @return the minimal length of a contiguous subarray of which the sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     */

    public int minSubArrayLen(int target, int[] nums) {
        int ptrSlow = 0;
        int length = nums.length;
        int minLength = length + 1;

        for (int ptrFast = 0; ptrFast < length; ptrFast++) {
            target -= nums[ptrFast];
            while (target <= 0) {
                // target is reached by subarray
                int subArrayLength = ptrFast - ptrSlow + 1;
                minLength = Math.min(minLength, subArrayLength);
                target += nums[ptrSlow];
                ptrSlow++; // moving to check next subarray starting at nums[ptrSlow]
            }
        }
        if (minLength > nums.length) { // case where subarray meeting target does not exist
            return 0;
        } else { return minLength; }
    }
}
