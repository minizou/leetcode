public class Problem27 {
    /**
     * 27. Remove Element (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using two pointers (nextEmpty and i), keep track of the next empty spot in the array (starting from
     *        the beginning) and the next unchecked element. If an element is not to be removed, put it in the next
     *        empty spot in the array using the nextEmpty pointer.
     *        - Increment the nextEmpty pointer now the spot has been filled.
     *      - Continue iterating the pointer keeping track of unchecked elements until all elements have been
     *        iterated through. Return the location of nextEmpty.
     *
     * @param nums - an integer array
     * @param val - an integer value
     * @return k after placing the final result in the first k slots of nums
     */


    public int removeElement(int[] nums, int val) {
        int nextEmpty = 0; // ptr keeping track of next empty spot in array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) { // non-removed number --> put in next empty spot in array
                nums[nextEmpty++] = nums[i];
                nextEmpty++;
            }
        }
        return nextEmpty;
    }
}
