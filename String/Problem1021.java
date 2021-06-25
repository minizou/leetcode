public class Problem1021 {
    /** 1021. Remove Outermost Parentheses (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length()
     *      - Space complexity: O(n) where n is s.length()
     * 2. Intuition
     *      - We are asked to get rid of the outermost parentheses of each individual primitive/unit in a string.
     *      - Consider how ) marks the end of a set of () while ( marks the beginning. Let ( be +1 and ) be -1
     *        such that a pair of parentheses () will add to 0.
     *      - Thus the outermost ) parentheses occurs when ')' is found adding to 0 in total. The ( parentheses
     *        that is outermost is the one following this particular ')'.
     *
     * @param s - a valid parentheses string consisting of only "(" and ")"
     * @return s after removing the outermost parentheses of every primitive string
     * in the primitive decomposition of s
     */
    
    public String removeOuterParentheses(String s) {
        int layer = 1; // tells how many "layers" of parentheses there are at a given moment
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                layer++;
            } else { layer--; } // case of ')'

            if (layer != 0) { // not outermost parentheses
                ans.append(s.charAt(i));
            } else if (s.charAt(i) == ')') { // end of primitive (see LeetCode problem description for definition)
                layer = 1;
                i++;
            }
        }
        return ans.toString();
    }
}
