public class Problem1877 {
    /** 1877. Minimize Maximum Pair Sum in Array (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(nlog(n)) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Consider how to get the minimum pair sum each time.
     *        - It is possible by adding each minimum value to the next maximum.
     *      - Sort the array so that it is possible to find these values in one loop.
     *      - Find each minimum pair sum by adding the first number (min) with the last in the array, then the
     *        second and the second-to-last, and so on. Return the max value of these sums.
     *
     * @param nums - an array of even length
     * @return the minimized maximum pair sum after optimally pairing up the elements in nums into n / 2 pairs
     */

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i * 2 < nums.length; i++) {
            max = Math.max(max,nums[i] + nums[nums.length - i - 1]);
        }
        return max;
    }
}
