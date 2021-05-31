public class Problem485 {
    /**
     * 485. Max Consecutive Ones (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Loop through nums, keeping track of the consecutive number of 0s with a counter.
     *      - If a 0 is reached, the consecutive count is broken. Check if this is the max consecutive count.
     *      - Check the max consecutive count after the loop in the case that the max was achieved
     *        without yet reaching a 0.
     *
     * @param nums - binary array consisting of 1s and 0s
     * @return the maximum number of consecutive 1s in the array
     */

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else { // 0 is found -- no longer consecutive
                if (count > max) { max = count; }
                count = 0;
            }
        }
        if (count > max) { max = count; }
        return max;
    }
}
