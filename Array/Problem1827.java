public class Problem1827 {
    /** 1827. Minimum Operations to Make the Array Increasing (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Iterate through nums and keep track of the next minimum number value (nextNum). Add to the number
     *        of operations the difference between the minimum number value and the current value if the current value
     *        is not large enough. Then change nums[i] accordingly if it is smaller than the minimum required value.
     *      - Update the minimum required number value and return the number of operations when done.
     *
     * @param nums - an integer array (0-indexed)
     * @return the minimum number of operations needed to make nums strictly increasing
     */

    // Method 1. Initial Solution
    public int minOperations(int[] nums) {
        int operations = 0, nextNum = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nextNum > nums[i]) {
                operations += (nextNum - nums[i]);
                nums[i] = nextNum++;
            } else {
                nextNum = nums[i] + 1;
            }
        }
        return operations;
    }

    // Method 2. Condensed Version of Method 1 using Math.max()
    public int minOperations2(int[] nums) {
        int operations = 0, nextNum = 0;
        for (int n : nums) {
            operations += Math.max(0, nextNum - n + 1);
            nextNum = Math.max(n, nextNum + 1);
        }
        return operations;
    }
}
