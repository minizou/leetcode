public class Problem1389 {
    /**
     * 1389. Create Target Array in the Given Order (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n^2) where n is nums.length
     *      - Space complexity: O(n) where n is nums.length
     * 2. Intuition
     *      - Loop through nums, adding each value in nums at the corresponding indice in index
     *      - If a value is already possibly in the indice, shift all elements at the indice
     *        to the right by one in the target array (O(n)).
     * 3. Alternative Approaches
     *      - ArrayList implementation
     *
     * @param nums - array of numbers
     * @param index - array of indices to insert numbers at
     * @return nums inserted at corresponding number in index at the same indices
     */

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length]; // solution array
        for (int i = 0; i < nums.length; i++) {
            if (index[i] < i) {
                // making room for insertion by shifting all elements at index to the right
                for (int j = i; j > index[i]; j--) {
                    target[j] = target[j - 1];
                }
            }
            target[index[i]] = nums[i]; // insertion
        }
        return target;
    }
}
