public class Problem1 {
    /**
     * 1. Two Sum (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n nums.length
     *      - Space complexity: O(n)
     * 2. Intuition
     *      - Store values in nums into a HashMap with its key being the number needed for the target to be reached
     *        (nums[i] + key = target). Thus, nums[i] is equal to one of the keys in the HashMap, then nums[i] and
     *        the value at that key are the two values that add to the sum.
     * 3. Alternative Approaches
     *      - Brute force method with nested for-loop for nums
     *
     * @param nums - array of integers
     * @param target - integer two integers in nums add up to
     * @return indices of the two numbers such that they add up to target
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) { // nums[i] + key = target
                return new int[] {i, map.get(nums[i])}; // solution found
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{-1,-1}; // solution not found
    }
}
