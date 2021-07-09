public class Problem75 {
    /** 75. Sort Colors (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length (2 pass)
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use counting sort. Note how, by the constraints of the problem, there are at most 3 different
     *        possible values for nums[i] (0,1,2).
     *      - Input the frequency of each nums[i] value at the index of a new array with the size of 3.
     *      - Iterating through the new array, input the index into the old array and decrease the array value at
     *        that index by one. Continue this process until each value in the new array is 0.
     * 3. Alternative Approaches
     *      - 1 Pass Dutch Partition
     *      - 2 Pointers Method
     *
     * @param nums - array with n objects colored red (0), white (1), or blue (2)
     * Sorts nums in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white, and blue (0, 1, and 2 respectively).
     */

    public void sortColors(int[] nums) {
        int count[] = new int[3];
        for (int i = 0; i < nums.length; i++) { // inputting frequency of 0, 1, and 2
            count[nums[i]]++;
        }
        int next = 0; // next unsorted spot in nums
        for (int i = 0; i < 3; i++) {
            while (count[i] > 0) {
                nums[next] = i;
                count[i]--;
                next++;
            }
        }
    }
}
