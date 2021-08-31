public class Problem189 {
    /** 189. Rotate Array (Medium)
     * 1. Complexity
     *      - Time complexity: O(n) [Methods 1-3] O(n * m) [Method 4]
     *      - Space complexity: O(1) [Methods 1-2] O(n) [Method 3]
     * 2. Intuition
     *      - [Method 1] Let n = nums.length. Note how, when rotating an array:
     *          - Values in the range [0, n - k - 1] move from their index i to i + k
     *          - Values in the range [n - k, n - 1] move from their index i to i + k - n
     *      - Using reverse on certain portions of the ranges, we achieve moving these indices.
     *      - [Method 2] Keep track of each value and index being replaced when rotating a value onto another.
     *          - Example: 0 1 2, k=2.
     *          - Calculate the rotated index for 0 (2).
     *          - Store the value of 2 before moving 0 to 2. Now calculate the rotated index for 2.
     *          - Repeat this process for all numbers, moving up an index if a cycle occurs.
     *      - [Method 3] At the cost of extra space, rotate the numbers in one loop by using the original values in
     *        a cloned array as reference.
     *      - [Method 4] Loop through a rotation k times in the array.
     *
     * @param nums - an array of integers
     * @param k - a non-negative number of steps to rotate the array right by
     */

    // Method 1. Space-Optimal using Reverse || Time O(n) | Space O(1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Method 2. Space-Optimal through Rotation-Skipping || Time O(n) | Space O(1)
    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        if (k == 0) { return; }

        int rotations = 0;
        int oldIndex = 0;
        int oldValue = nums[0];
        int firstIndex = oldIndex;

        while (rotations < nums.length) {
            int newIndex = (oldIndex + k) % nums.length;
            int newValue = nums[newIndex];

            nums[newIndex] = oldValue;
            oldIndex = newIndex;
            oldValue = newValue;

            if (oldIndex == firstIndex) {
                oldIndex++;
                oldValue = nums[oldIndex];
                firstIndex = oldIndex;
            }
            rotations++;
        }
    }


    // Method 3. Using Extra Space || Time O(n) | Space O(n)
    public void rotate3(int[] nums, int k) {
        int[] og = nums.clone();
        int len = nums.length;
        k %= len;

        for (int i = 0; i < len; i++) {
            nums[(i + k) % len] = og[i];
        }
    }

    // Method 4. Brute-Force || Time O(n * m) | Space O(1)
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }
}
