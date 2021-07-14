public class Problem22 {
    /** 22. Generate Parentheses (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(m*n) where m is the nth Catalan number [CHECK]
     *      - Space complexity: O(m*n) where m is the nth Catalan number [CHECK]
     * 2. Intuition
     *      - Using backtracking, consider the constraints of the problem:
     *        - 1. There are two choices each recursive call: "(" and ")".
     *        - 2. The number of "(" must be equal or greater than ")" at all times
     *             (i.e, you can't start with ")").
     *        - 3. There must be n number of "(" and n number of ")".
     *        - 4. Valid solutions have a total of n * 2 char (base case).
     *      - Add valid solutions to the answer list using backtracking from these constraints.
     * 3. Alternative Approaches
     *      - Possibly a Dynamic Programming solution [Have Not Checked]
     *      - Brute Force Method
     *
     * @param n - number of pairs of parentheses
     * @return a list of all combinations of n well-formed parentheses
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans,"",0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans, String currentStr, int open, int close, int n) {
        if (currentStr.length() == n * 2) { // base case
            ans.add(currentStr);
            return;
        }
        // backtracking portion
        if (open < n) { // can still use open parentheses
            backtrack(ans, currentStr + "(", open + 1, close, n);
        }
        if (close < open) { // can add closed parentheses
            backtrack(ans, currentStr + ")", open, close + 1, n);
        }
    }
}
