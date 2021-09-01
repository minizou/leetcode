public class Problem283 {
    /** 283. Move Zeroes (Easy)
     * 1. Complexity
     *      - Time complexity: O(n) where n = nums.length [Both Methods]
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - [Method 1] Keep track of the number of zeroes while looping, and switch the zeroes
     *        and the non-zero values as they appear.
     *      - [Method 2] Use two pointers: (1) starts at the front of the array and keeps track of the last sorted non-zero value,
     *        (2) actually finds the next non-zero value in the array
     *      - First put all the non-zero values in the front of the array using (1) as (2) finds them, moving (1)
     *        each time a non-zero value is found.
     *      - Then move (1) to the end of the array, letting each remaining array value be 0.
     * @param nums - an integer array possibly containing 0s
     */

    // Method 1. 1 Loop
    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if (zeroes > 0) {
                // switch
                nums[i - zeroes] = nums[i];
                nums[i] = 0;
            }
        }
    }

    // Method 2. 2 Loops
    public void moveZeroes2(int[] nums) {
        int ptr = 0; // no zeros
        int ptr2 = 0; // front

        while (ptr < nums.length) {
            if (nums[ptr] != 0) {
                nums[ptr2] = nums[ptr];
                ptr2++;
            }
            ptr++;
        }

        while (ptr2 < nums.length) {
            nums[ptr2++] = 0;
        }
    }
}
