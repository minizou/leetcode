public class Problem643 {
    /** 643. Maximum Average Subarray I (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using a sliding window approach, begin by examining the subarray of the first k elements in nums.
     *      - Note how the next possible contiguous subarray with k elements has the same elements as the first
     *        subarray except for the first element and the last element in the subarray.
     *      - "Slide" the window to represent this by deleting the first element in the previous window
     *        from the sum.
     *      - Continue this process until the max average is found.
     *
     * @param nums - an integer array
     * @param k - an integer value
     * @return a contiguous subarray whose length is equal to k that has the maximum average value
     */

    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0; // running sum
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd]; // adds elements in window
            if (windowEnd >= k - 1) { // max window size is reached: subarray is found
                if (( sum / k ) > max || windowStart == 0) {
                    max = sum / k;
                }
                // sliding the window
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        return max;
    }
}
