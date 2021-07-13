public class Problem268 {
    /** 268. Missing Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is nums.length [Method 1 & 2]
     *                         O(log(n)) where n is nums.length [Method 3]
     *      - Space complexity: O(1) [All Methods]
     * 2. Intuition
     *      - [Method 1] Note how the sum of 0 through n can be expression as n * (n+1) / 2:
     *        Let    F(n) = 1 + 2 + 3 + 4 + ... + (n-1) + n. Therefore,
     *        F(n) + F(n) = 1 +   2   +   3   + ... + (n-1) + n
     *                    + n + (n-1) + (n-2) +	... +   2   + 1
     *                    = (n+1) + (n+1) + (n+1) + ... + (n+1)
     *             2 F(n) = n * (n+1)
     *               F(n) = n * (n+1) / 2.
     *      - Iterate through nums and subtract each number from the total summation. The remaining number will be
     *        the missing one. Return this remaining sum.
     *
     *      - [Method 2] Note how every number XOR itself is 0: 1^1 = 0, 1345 ^ 1345 = 0, etc.
     *      - Similarly 1 ^ 1 ^ 23 ^ 23 ^ 52 ^ 3 ^ 3 = 52. Thus we compare the XOR between each number in 0 through n
     *        and through each number in nums. The remaining XOR value will be the missing number.
     *
     *      - [Method 3] Sort through the array and use binary search to find the missing number by comparing
     *        the index of a value and its actual value.
     * 3. Alternative Approaches
     *
     * @param nums - an array containing n distinct numbers in the range [0, n]
     * @return the only number in the range that is missing from the array
     */

    // Method 1. Summation Formula Taking Advantage of Series
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    // Method 2. XOR Operation
    public int missingNumber2(int[] nums) {
        int XOR = 0;
        int i = 0;
        while (i < nums.length) { // iterate through all of nums
            XOR ^= i; // i = a number in the range
            XOR ^= nums[i++];
        }
        return XOR ^ i;
    }

    // Method 3. Binary Search
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > mid) { // missing number below mid
                high = mid;
            } else { low = mid + 1; }
        }
        return low;
    }
}
