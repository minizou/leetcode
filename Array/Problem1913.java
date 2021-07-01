import java.util.Arrays;

public class Problem1913 {
    /** 1913. Maximum Product Difference Between Two Pairs (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n + m) where n is nums.length and m is the possible value range (10000) as noted by
     *        the problem constraints [Method 1]
     *                         O(nlog(n)) where n is nums.length [Method 2]
     *      - Space complexity: O(n) where n is the possible value range and nums.length [Method 1]
     *                          O(n) where n is nums.length [Method 2]
     * 2. Intuition
     *      - [Method 1] Using counting sort, create an array and put each element in nums into the array at its
     *        index by incrementing the value at that index by 1 each time. Then sort in-place based on the order
     *        presented in the created array.
     *      - [Method 2] Use the built-in sort algorithm.
     *      - [Both Methods] Once sorted, the maximum product can be obtained by multiplying the two largest values
     *        and the two smallest values. Return the maximum product from these 4 numbers.
     *
     * @param nums - an integer array with a minimum length of 4
     * @return the maximum possible product difference ((a * b) - (c * d))
     */

    // Method 1. Counting Sort
    public int maxProductDifference(int[] nums) {
        // Counting sort
        int[] count = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int next = 0; // next index of sorted value in nums
        for (int i = 0; i < 10001; i++) {
            while (count[i] > 0) { // nonempty values only
                nums[next] = i;
                count[i]--;
                next++;
            }
        }
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

    // Method 2. Naive / Built-In Sort Solution
    public int maxProductDifference2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}
