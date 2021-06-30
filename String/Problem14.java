public class Problem14 {
    /** 14. Longest Common Prefix (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n * m) where n * m is the sum of all the char of every string in strs [Both Methods]
     *      - Space complexity: O(1) [Method 1]
     *                          O(n) where n is the length of the longest string in strs [Method 2]
     * 2. Intuition
     *      - [Method 1] The first string is compared to the next, retaining only the shared prefix between the two
     *        using indexOf() and substring(). Then this string is compared to the next, and so on until all
     *        strings have been iterated through.
     *      - The remaining shared prefix is the longest common prefix between all the strings.
     *      - [Method 2] Similar to Method 1, find the common string prefix between every two strings and keep
     *        the shortest one.
     * 3. Alternative Approaches
     *      - Sort the array and then compare the prefixes of the first and last element in the array.
     *      - Use Binary Search / Divide and Conquer method (see Problem 14 in Binary Search folder).
     *
     * @param strs - an array of strings that consist of only lower-case English letters
     * @return the longest common prefix string amongst an array of strings
     */

    // Method 1. Horizontal Scanning (Condensed)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) { return ""; }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) { // checking for common prefix
                ans = ans.substring(0, ans.length() - 1); // decreasing to common prefix
                System.out.println(ans);
            }
        }
        return ans;
    }

    // Method 2. Initial Solution
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1) { return strs[0]; }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length - 1; i++) {
            StringBuilder common = new StringBuilder(); // common prefix between two strings
            int len = Math.min(strs[i].length(),strs[i+1].length());
            for (int j = 0; j < len; j++) {
                if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                    common.append(strs[i].charAt(j)); // adds char if common prefix
                } else {
                    break;
                }
            }
            if (i == 0 || ans.length() > common.length()) { // compares which prefix is shorter
                ans = common;
            }
        }
        return ans.toString();
    }
}