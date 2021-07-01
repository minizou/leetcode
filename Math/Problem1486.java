public class Problem1486 {
    /** 1486. XOR Operation in an Array (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of elements [Method 1]
     *                         O(1) [Method 2]
     *      - Space complexity: O(1) [Both Methods]
     * 2. Intuition
     *      - [Method 1] Iterate and increment through start (adding 2 * i each time) until i loops n times.
     *        Calculate the bitwise operation using ^.
     *      - [Method 2] We take advantage of a property of the XOR bitwise operator. Consider the pattern of XOR
     *        for when n = 0, 1, 2, 3, etc.. It repeats every 4 iterations. Specifically, depending on the value
     *        of start and n, the patterns range from being constants to start ^ 2 ^ lastNum.
     *
     * @param n - number of elements in nums
     * @param start - int value to start at
     * @return bitwise XOR of all elements in nums where nums[i] = start + 2*i (0-indexed) and n == nums.length
     */

    // Method 1. Self-Explanatory
    public int xorOperation(int n, int start) {
        int bit = start;
        for (int i = 1; i < n; i++) {
            bit ^= (start + 2 * i);
        }
        return bit;
    }

    // Method 2. Utilizing Properties of XOR Bitwise Operator
    public int xorOperation2(int n, int start) {
        int firstNum = start; // first number in operation
        int lastNum = start + 2 * (n - 1); // last number in operation

        if (start % 4 == 1 || start % 4 == 0) { // start % 4 == 0 or 1
            switch(n % 4) {
                case 0:
                    return 0;
                case 1:
                    return lastNum;
                case 2:
                    return 2;
                default: // case of "3"
                    return lastNum ^ 2;
            }
        } else { // start % 4 == 2 or 3
            switch(n % 4) {
                case 0:
                    return start ^ 2 ^ lastNum;
                case 1:
                    return start;
                case 2:
                    return start ^ lastNum;
                default: // case of "3"
                    return start ^ 2;
            }
        }
    }
}
