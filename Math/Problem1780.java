public class Problem1780 {
    /**
     * 1780. Check if Number is a Sum of Powers of Three (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the size of the number
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - The sum of powers of three is easier always
     *          1.) a multiple of three, or
     *          2.) a multiple of three + 1 (since 3^0 = 1).
     *      - It follows that if n is a sum of powers of three, it can't have a remainder of 2 when
     *        divided by 3 any number of times (i.e. the ternary presentation cannot have a 2 in it).
     * 3. Alternative Approaches
     *      - HashSet implementation
     *
     * @param n - integer
     * @return whether it is possible to represent n as the sum of distinct powers of three
     */

    // Method 1. Iterative Solution
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) { // impossible condition for sum of powers of three
                return false;
            }
            n /= 3;
        }
        return true; // is sum
    }

    // Method 2. Recursive Solution
    public boolean checkPowersOfThree2(int n) {
        if (n <= 0) { // base case - is sum
            return true;
        } else if (n % 3 == 2) { // impossible condition for sum of powers of three
            return false;
        } else {
           return checkPowersOfThree2(n / 3);
        }
    }
}