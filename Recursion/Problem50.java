public class Problem50 {
    /** 50. Pow(x, n) (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the value of n
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - We will use a divide an conquer algorithm. Consider how x^n = x^(n/2) * x^(n/2) and so forth.
     *      - Thus we will recursively divide the n value by 2 and do log_2(n) steps, eventually
     *        multiplying by these values until the power of x^n is calculated.
     * 3. Alternative Approaches
     *      -
     *
     * @param x- a double value
     * @param n - an integer value
     * @return x raised to the power n
     */
    public double myPow(double x, int n) {
        if (n == 0) {  // edge case
            return 1;
        }
        double temp = myPow(x, n/2); // recursive call
        if (n % 2 == 0) { // see first bullet on intuition comment
            return temp * temp;
        } else if (n > 0) {
            return x * temp * temp;
        } else {
            return (temp * temp) / x;
        }
    }
}
