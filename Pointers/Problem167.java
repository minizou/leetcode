import java.util.HashMap;

public class Problem167 {
     /** 167. Two Sum II - Input Array is Sorted (Easy)
     * 1. Complexity
     *      - Time complexity: O(n) where n = nums.length [Both Methods]
     *      - Space complexity: O(1) [Method 1], O(n) where n = nums.length [Method 2]
     * 2. Intuition
     *      - [Method 1] Note how the array is already sorted. Use two pointers to find the sum: one
     *        at the front of the array and one at the end of the array.
     *          - If the sum of the values of the two pointers is equal to the target, return the pointer values.
     *          - If the sum is greater than the target, decrease the end pointer.
     *          - If the sum is less than the target, continue increasing the front pointer.
     *      - [Method 2] Similar to Problem 1. Two Sum, use a HashMap to record the counterpart to each value at
     *        an index such that the nums[i] + counterpart = target. Then loop through the array again until
     *        one of the counterparts in the HashMap is found.
     * @param nums - input integer array
     * @param target - target integer sum value of two items in nums
     * @return the indices (starting from 1) of the two items in the array that add up to target
     */

    // Method 1. Two Pointers
    public int[] twoSum(int[] nums, int target) {
        int ptr1 = 0; // slow
        int ptr2 = nums.length - 1; // fast

        while (ptr1 < ptr2) {
            int sum = nums[ptr1] + nums[ptr2];
            if (sum == target) {
                return new int[]{ptr1 + 1, ptr2 + 1};
            } else if (sum < target) {
                ptr1++;
            } else { // sum > target
                ptr2--;
            }
        }
        return new int[]{-1,-1}; // solution not found
    }


    // Method 2. Sub-Optimal Brute Force
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] ans = new int[2];
                ans[0] = Math.min(i + 1,map.get(nums[i]) + 1);
                ans[1] = Math.max(i + 1,map.get(nums[i]) + 1);
                return ans;
            }
        }
        return new int[]{-1,-1};
    }
}
