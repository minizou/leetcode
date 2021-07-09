public class Problem231 {
    /** 231. Power of Two (Easy)
     *
     * This problem is very similar to Problem 326 and 342.
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) [Methods 1 & 2]
     *                         O(1) [Method 3]
     *      - Space complexity: O(1) [All Methods]
     * 2. Intuition
     *      - [Method 1 and 2] Recursively or iteratively divide the input by 2 until the input is <= 1
     *      - Also check if n % 2 != 0 and n > 1. If so, then the number is not a power of two
     *        (has factors other than 2)
     *      - [Method 3] Taking advantage of bitwise addition, note how n & n - 1 (bitwise) always equals 0 for
     *        powers of 2 (that are positive).
     *
     * @param n where -2^31 <= n <= 2^31 - 1
     * @return true if n is a power of two. Otherwise, return false.
     */

    // Method 1. Recursive / Initial Solution
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        }
        return (n % 2 == 0 && isPowerOfTwo(n/2));
    }

    // Method 2. Iterative
    public boolean isPowerOfTwo2(int n) {
        while (n > 1 && n % 2 == 0) {
            n /= 2;
        }
        return (n == 1);
    }

    // Method 3. Bit Manipulation
    public boolean isPowerOfTwo3(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }



}
