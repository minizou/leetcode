public class Problem136 {
    /**
     * 136. Single Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length
     *      - Space complexity: O(n) for HashSet method, O(1) for Bitwise XOR method
     * 2. Intuition
     *      - HashSet Method: Loop through nums and removes duplicates (if a number is already in the set, then it
     *        will be a duplicate), leaving only the single number in the set
     *      - Bitwise XOR method: Loop through nums and use XOR to add the single digit to num; since each duplicate
     *        appears twice, the XOR function on it results in zero for duplicates (let N be any number; N ^ N = 0).
     *        Hence num will result in (0 ^ 0 ^ 0 .... ^ 0) ^ N -- only the non-duplicate element will be in nums.
     *
     * @param nums - on-empty array of integers where every element appears twice except for one
     * @return element that appears only once in nums
     */

    // Method 1 - Using HashSet
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            // if not possible to add to set --> duplicate exists --> remove duplicate from set
            if (set.add(nums[i]) == false) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next(); // only single number remains
    }

    // Method 2 - Using bitwise XOR
    public int singleNumber2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            // (0 ^ 0 ^ ... ^ 0) ^ N = N; double duplicates become 0 (N ^ N = 0)
            num = num ^ nums[i];
        }
        return num; // only non-duplicate number remains
    }
}
