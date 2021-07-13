public class Problem263 {
    /** 263. Ugly Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the value of n [Both Methods]
     *      - Space complexity: O(1) [Both Methods]
     * 2. Intuition
     *      - [Both Methods] Recursively or iteratively check through whether n is divisible by 2, 3, or 5. If so,
     *        divide by this value and let it be the new value of n. If n is not divisible through any of these
     *        factors (and n > 1), then return false (as it has a factor other than 2, 3, and 5). If the number is
     *        negative, return false. If the number is 1, return true (no more other factors).
     *
     * @param n - an integer value
     * @return true if n is a positive integer whose prime factors are limited to 2, 3, and 5
     */

    // Method 1. Iterative
    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 5 == 0) {
                n /= 5;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else { // other factors exist
                return false;
            }
        }
        return n == 1 ? true : false;
    }

    // Method 2. Recursive
    public boolean isUgly2(int n) {
        if (n < 1) { // base case
            return false;
        } else if (n == 1) { // base case
            return true;
        } else if (n % 5 == 0) {
            return isUgly2(n / 5);
        } else if (n % 3 == 0) {
            return isUgly2(n / 3);
        } else if (n % 2 == 0) {
            return isUgly2(n / 2);
        } else {
            return false;
        }
    }
}
