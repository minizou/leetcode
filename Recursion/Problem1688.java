public class Problem1688 {
    /**
     * 1. Complexity
     *      - Time complexity: O(log n) where n is number of matches [Method 1], O(1) [Method 2]
     *      - Space complexity: O(1) [Both methods]
     * 2. Intuition
     *      - [Method 1] Recursively follow the rules, calling the function for each
     *        number of advancing players until a winner is found and add the sum of the number of matches played
     *        as the function is called once more.
     *      - [Method 2] Note how one team is eliminated per match (see LeetCode problem for specific details).
     *        Thus, since there is one winner, when there are n team, a total of n - 1 must be eliminated and thus
     *        a total of n - 1 matches are played.
     * 3. Alternative Approaches
     *      - Iterative solution using while loop
     *      - Reduce if-else-statement to ternary operator (?)
     *
     * @param n - the number of teams in a tournament (see Leetcode Problem for specific rules)
     * @return the number of matches played in the tournament until a winner is decided
     */

    // Method 1.
    public int numberOfMatches(int n) {
        if (n == 1) { // base case - winner is found, no more matches played
            return 0;
        }
        if (n % 2 == 0) { // even current # of teams
            return (n/2) + numberOfMatches(n/2);
        } else { // odd current # of teams
            return ((n-1)/2) + numberOfMatches((n-1)/2+1);
        }
    }

    // Method 2.
    public int numberOfMatches2(int n) {
        return n - 1;
    }
}
