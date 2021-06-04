public class Problem70 {
    /**
     * 70. Climbing Stairs (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the int value of n [Both methods]
     *      - Space complexity: O(n) where n is the int value of n [Both methods]
     * 2. Intuition
     *      - [Both Methods] There are two options each iteration: take 1 step or take 2 steps.
     *      - Hence you can either take (n - 1) or (n - 2) steps from the previous step.
     *      - Therefore the total number of ways to reach the nth step is:
     *        [# of ways to reach nth step] = [number of ways to reach n - 1 steps] + [number of ways to reach n - 2]
     * 3. Alternative Approaches
     *      - Replace tab[] array with two primitives keeping track of the second to last and last values calculated
     *        (Fibonacci approach).
     *
     * @param n - number of steps it takes to climb the stairs
     * @return the number of distinct ways possible to climb the stairs where each time you can
     *         either climb 1 or 2 steps
     */

    // Method 1. Bottom Up DP Solution
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] tab = new int[n];
        tab[0] = 1; // base case values
        tab[1] = 2;

        for (int i = 2; i < n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n - 1];
    }

    // Method 2. Top Down DP Solution
    public int climbStairs2(int n) {
        int tab[] = new int[n + 1];
        return helper(n, tab);
    }

    public int helper(int n, int[] tab) {
        if (n < 0) { // base case
            return 0;
        } else if (n == 0) { // base case
            return 1;
        } else if (tab[n] > 0) { // value already stored in array
            return tab[n];
        }
        tab[n] = helper(n - 1, tab) + helper(n - 2, tab);
        return tab[n];
    }
}
