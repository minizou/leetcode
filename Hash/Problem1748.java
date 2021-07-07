import java.util.HashSet;

public class Problem1748 {
    /** 1748. Sum of Unique Elements (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(n) where n is nums.length
     * 2. Intuition
     *      - Loop through nums and keep track of numbers encountered using a set.
     *        - If a number is already in the set, add it to a set tracking non-unique numbers.
     *          - If it isn't already in the set of non-unique numbers, subtract it from the sum.
     *        - Otherwise, if the number is not in either set, add it to the sum.
     *      - Return the sum.
     *
     * @param nums - an integer array
     * @return the sum of all the unique elements of nums
     */

    public int sumOfUnique(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>(); // keeps track of unique nums
        HashSet<Integer> notUniq = new HashSet<Integer>();  // keeps track of non-unique nums
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) && !notUniq.contains(nums[i])) { // number not encountered before
                sum += nums[i];
            } else if (!notUniq.contains(nums[i])) { // repeat found for first time for number
                sum -= nums[i];
                notUniq.add(nums[i]);
            }
        }
        return sum;
    }
}
