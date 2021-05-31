public class Problem977 {
    /**
     * 977. Squares of a Sorted Array (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(n) where n is nums.length
     * 2. Intuition
     *      - Use a two-pointers method. Note how in an already sorted array in non-decreasing order, the greatest
     *        squared values will be along the ends of the array.
     *      - Set a pointer at the beginning of the array (ptrStart) and the end (ptrEnd). Compare the values at
     *        the pointers.
     *        - Input the greater value between the two pointers into the solution array
     *          (starting at the end of the array) and move its corresponding pointer
     *          (increase index if ptrStart, decrease index if ptrEnd).
     *        - Keep track of the next last free index in the solution array.
     *        - Repeat this process until the pointers are pointing at the same value. Then add that final value
     *          to the solution array.
     * 3. Alternative Approaches
     *      - Brute force method by squaring each number into an array
     *        and then sorting said array with a sorting algorithm of choice
     *
     * @param nums - an integer array sorted in non-decreasing order
     * @return an array of the squares of each number sorted in non-decreasing order
     */

    public int[] sortedSquares(int[] nums) {
        int[] solution = new int[nums.length];
        int solIndex = nums.length - 1; // last next free index
        int ptrStart = 0; // points to start index of nums
        int ptrEnd = nums.length - 1; // points to end index of nums

        while (ptrStart < ptrEnd) { // until pointers converge to point at the same thing
            if ((nums[ptrStart] * nums[ptrStart]) > (nums[ptrEnd] * nums[ptrEnd])) {
                solution[solIndex] = nums[ptrStart] * nums[ptrStart];
                ptrStart++;
            } else { // | nums[ptrEnd]| >= | nums[ptrStart] |
                solution[solIndex] = nums[ptrEnd] * nums[ptrEnd];
                ptrEnd--;
            }
            solIndex--;
        }
        solution[0] = nums[ptrEnd] * nums[ptrEnd];
        return solution;
    }
}
