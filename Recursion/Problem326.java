public class Problem326 {
    /** 326. Power of Three (Easy)
     *
     * This problem is very similar to Problem 231 and 342.
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) [Methods 1 & 2]
     *                         O(1) [Method 3]
     *      - Space complexity: O(1) [All Methods]
     * 2. Intuition
     *      - [Method 1 and 2] Recursively or iteratively divide the input by 3 until the input is <= 1
     *      - Also check if n % 3 != 0 and n > 1. If so, then the number is not a power of two
     *        (has factors other than 3)
     *      - [Method 3] Take advantage of the constraints of n and find the largest possible value for the 32-bit
     *        int that is a power of 3. THen check if n is both positive and divisible at the number.
     *
     * @param n where -2^31 <= n <= 2^31 - 1
     * @return true if n is a power of three. Otherwise, return false
     */

    // Method 1. Recursive / Initial Solution
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        }
        return (n % 3 == 0 && isPowerOfThree(n/3));
    }

    // Method 2. Iterative
    public boolean isPowerOfThree2(int n) {
        while (n > 1 && n % 3 == 0) {
            n /= 3;
        }
        return (n == 1);
    }

    // Method 3. Using Constraints of n
    public boolean isPowerOfThree3(int n) {
        int max = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3)));
        return (n > 0) && (max % n) == 0;
    }
}
