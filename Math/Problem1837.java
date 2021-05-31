public class Problem1837 {
    /**
     * 1837. Sum of Digits in Base K (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the integer value of n
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - We are essentially converting a number (in base 10) to base k. Recall that for any number in base 10,
     *        n = c_0 (k^0) + c_1 (k^1) + c_2 (k^2) + ... + c_i (k^i), where c_0, c_1, etc. are constants.
     *      - Example: 13 = 1 (3^2) + 1 (3^1) + 1 (3^0) --> 111 in base 3
     *      - To convert the sum of the digits of a number in base k, take the last digit (coefficients) and add
     *        it to the sum. Then divide by the base.
     *
     * @param n - integer in base 10
     * @param k - integer base value
     * @return the sum of the digits of n after converting n from base 10 to base k
     */

    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}
