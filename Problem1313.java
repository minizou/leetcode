public class Problem1313 {
    /**
     * 1313. Decompress Run-Length Encoded List (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n^2) where n is nums.length
     *      - Space complexity: O(n) where n is nums.length
     * 2. Intuition
     *      - Add up frequencies in for-loop to determine solution array length
     *      - Loop values into solution array by iterating each value based on its frequency
     *
     * @param nums
     * @return decompressed run-length encoded list
     */

    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        int next = 0; // keeps track of next empty index in solution array

        for (int i = 0; i < nums.length; i = i + 2) { // determines solution array length
            length += nums[i];
        }

        int[] decompressedNums = new int[length]; // solution array

        for (int i = 1; i < nums.length; i = i + 2) { // iterates through all val in nums
            for (int j = 0; j < nums[i - 1]; j++) { // iterates based on freq of val
                decompressedNums[next++] = nums[i];
            }
        }
        return decompressedNums;
    }
}
