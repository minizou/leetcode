public class Problem3 {
    /** 3. Longest Substring Without Repeating Characters (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length()
     *      - Space complexity: O(n) where n is s.length()
     * 2. Intuition
     *      - Note how we are asked to find the longest substring without repeated characters. In other words,
     *        we want to find the longest substring of unique characters. This substring will have the
     *        largest HashSet size.
     *      - We will use a 2 pointers approach.
     *          - Use a (fast) pointer to determine whether a char is a repeated char (whether it's
     *            in the HashSet or not).
     *          - Use another (slow) pointer to keep track of the beginning of a possible substring. When a repeated
     *            char is found, remove this char from the sequence and move this pointer to the next char in the
     *            sequence to represent going through the next substring.
     *      - Continue this process until the maximum length is found.
     * 3. Alternative Approaches
     *      - Sliding window approach (similar to 2 pointers)
     *
     * @param s - a string consisting of English letters, digits, symbols and spaces
     * @return the length of the longest substring without repeating characters
     */

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<Character>();
        int ptrSlow = 0;
        int ptrFast = 0;
        int maxLength = 0;
        while (ptrFast < s.length()) {
            if (!chars.add(s.charAt(ptrFast))) { // repeated char found
                chars.remove(s.charAt(ptrSlow));
                ptrSlow++; // next substring is looked at
            } else { // unique char found in sequence
                ptrFast++;
                maxLength = Math.max(chars.size(),maxLength);
            }
        }
        return maxLength;
    }
}
