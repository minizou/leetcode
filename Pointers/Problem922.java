public class Problem922 {
    /** 922. Sort Array By Parity II (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length [Both Methods]
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - [Method 1] Find where the first misplaced even int is and the first misplaced odd int is by using
     *        two pointers. Then swap them. Continue this process until there are no more misplaced elements.
     *      - [Method 2] Whenever a wrong parity is found, swap it with the next element and continue swapping
     *        until the correct parity is found. Continue this process for the other elements in the array.
     * 3. Alternative Approaches
     *      - Using 2 pointers, create a new array and loop through nums, having 1 pointer on the odds and one on
     *        the evens. Input them into the new array in the proper parity order.
     *
     * @param nums - array where half of the integers are odd, and the other half are even
     * @return the array sorted so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even
     */

    // Method 1. Optimized,
    public int[] sortArrayByParityII(int[] nums) {
        int ptr1 = 0;
        int ptr2 = 1;
        int length = nums.length;

        while (ptr1 < length && ptr2 < length) {
            // finding the next odd num in even spot
            while (ptr1 < length && nums[ptr1] % 2 == 0) {
                ptr1 += 2;
            }
            // finding the next even num in odd spot
            while (ptr2 < length && nums[ptr2] % 2 == 1) {
                ptr2 += 2;
            }
            if (ptr1 < length && ptr2 < length) {
                // swapping wrong parities so that they were correct
                int temp = nums[ptr1];
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = temp;
            }
        }
        return nums;
    }

    // Method 2. Initial Solution
    public int[] sortArrayByParityII2(int[] nums) {
        int ptr1 = 0;
        int ptr2 = 1;
        int temp = 0;

        while (ptr2 < nums.length) {
            if (ptr1 % 2 == 0 ^ nums[ptr1] % 2 == 0) { // wrong parity found
                // swapping wrong parity with next element
                temp = nums[ptr1];
                nums[ptr1] = nums[ptr2];
                nums[ptr2++] = temp;
            } else {
                ptr1++;
                ptr2 = ptr1 + 1;
            }
        }
        return nums;
    }
}
