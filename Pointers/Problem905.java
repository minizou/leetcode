public class Problem905 {
    /** Sort Array By Parity (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using a 2-pointers approach, have one pointer at the beginning of the array and another at the end.
     *      - Have the first pointer switch values with the second pointer if the value at the first pointer is
     *        odd. Move the second pointer if this is the case. If even, move the first pointer forward.
     *      - This will continue to move through all the elements until all the elements are sorted by parity.
     * 3. Alternative Approaches
     *      - Brute force method with nested for-loop for nums
     *
     * @param nums - non-negative integers
     * @return an array consisting of all the even elements of nums, followed by all the odd elements of nums
     */

    public int[] sortArrayByParity(int[] nums) {
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        int temp = 0; // for switching values of nums[ptr1] and nums[ptr2]

        while (ptr1 < ptr2) {
            if (nums[ptr1] % 2 != 0) { // odd
                temp = nums[ptr2];
                nums[ptr2--] = nums[ptr1];
                nums[ptr1] = temp;
            } else {
                ptr1++;
            }
        }
        return nums;
    }
}
