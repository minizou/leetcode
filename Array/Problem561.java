public class Problem561 {
    /** 561. Array Partition I (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n + m) where n is nums.length and m is the largest value in nums [Method 1]
     *                         O(nlog(n)) where n is nums.length [Method 2]
     *      - Space complexity: O(n + m) where n is nums.length and m is the largest value in nums [Method 1]'
     *                          O(1) [Method 2]
     * 2. Intuition
     *      - [Method 1] Sort the array using counting sort. First, initialize a new array and input the frequency
     *        of each nums[i] value at its index. Then, using this frequency table, sort the items in num using
     *        these frequencies by decreasing the frequency value the as they are inputted in nums.
     *      - [Method 2] Use Arrays.sort for sorting.
     *      - [Both Methods] Note how the maximized sum is derived from pairing the largest numbers together and
     *        the smallest numbers together. Once sorted, loop through nums and partition every two values together
     *        and add this value to obtain the max sum.
     *
     * @param nums - an integer array of 2n integers
     * @return  the maximized sum where the int in nums are grouped into n pairs where the sum of min(a_i, b_i)
     * for all i is maximized
     */

    // Method 1. Counting Sort Method
    public int arrayPairSum(int[] nums) {
        // note: -10000 <= nums[i] <= 10000 by problem constraints
        int[] arr = new int[20001];

        // inputting frequency of each nums[i] value
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] + 10000]++;
        }
        int next = 0; // next index of sorted value in nums
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) { // nonempty values only
                nums[next] = i - 10000;
                arr[i]--;
                next++;
            }
        }
        // finding max sum
        int maxSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        return maxSum;
    }

    // Method 2. Arrays.sort Method
    public int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        // finding max sum
        int maxSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        return maxSum;
    }
}
