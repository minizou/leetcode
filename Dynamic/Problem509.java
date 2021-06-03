public class Problem509 {
    /**
     * 509. Fibonacci Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the int value
     *      - Space complexity: O(n)
     * 2. Intuition
     *      - Using a bottom-up memoization approach, we compute the
     *        subproblem values of fib(i) from the bottom up and storing their values
     *        in an array.
     *      - We add the base case values for fib(0) and fib(1) (0 and 1) into the array.
     *      - Then, we loop through the values between 2 and n and calculate each subsequent fib(i) value and
     *        store it in the array. This way, each subsequent calculation uses what is already calculated
     *        in the array and does not need to do extra or redundant calculations that haven't already been done.
     * 3. Alternative Approaches
     *      - Regular Recursive Solution
     *      - Top-Down Solution
     *          - Both memoized and iteratively
     *
     * @param n - int value >= 0 (Note: F(0) = 1 and F(1) = 1)
     * @return F(n) where F(n) = F(n - 1) + F(n - 2), for n > 1.
     */


    public int fib(int n) {
        if (n < 2) { // base case
            return n;
        }

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
