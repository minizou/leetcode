public class Problem342 {
    /** 342. Power of Four (Easy)
     *
     * This problem is very similar to Problem 231 and 326.
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) [Methods 1 & 2]
     *                         O(1) [Method 3]
     *      - Space complexity: O(1) [All Methods]
     * 2. Intuition
     *      - [Method 1 and 2] Recursively or iteratively divide the input by 4 until the input is <= 1
     *      - Also check if n % 4 != 0 and n > 1. If so, then the number is not a power of two
     *        (has factors other than 4)
     *      - [Method 3] Taking advantage of bitwise addition, note how n & n - 1 (bitwise) always equals 0 for
     *        powers of 4 (that are positive).
     *
     * @param n where -2^31 <= n <= 2^31 - 1
     * @return true if n is a power of four. Otherwise, return false
     */

    // Method 1. Recursive / Initial Solution
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        } else {
            return (n % 4 == 0 && isPowerOfFour(n/4));
        }
    }

    // Method 2. Iterative
    public boolean isPowerOfFour2(int n) {
        while (n > 1 && n % 4 == 0) {
            n /= 4;
        }
        return (n == 1);
    }

    // Method 3. Bit Manipulation
    public boolean isPowerOfFour3(int n) {
        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0x55555555) == n);
    }
}
