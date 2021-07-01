public class Problem1816 {
    /** 1816. Truncate Sentence (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length() [Both Methods]
     *      - Space complexity: O(n) where n is s.length() [Both Methods]
     * 2. Intuition
     *      - [Method 1] Find where the last word is by counting down the number of spaces from k when looping
     *        through s. Then use the substring function to cut s based on the index of the last space.
     *      - [Method 2] Similarly to Method 1, count the number of spaces to determine the end of the truncated
     *        sentence. Rather than using substring, continuously concatenate to a string until the last space is
     *        reached and return this string.
     * 3. Alternative Approaches
     *      - Use built-in split function to split by spaces and iterate only over the first k words.
     *
     * @param s - a list of words that are separated by a single space with no leading or trailing spaces
     * @param k - an integer value
     * @return s such that it contains only the first k words
     */

    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length() && k > 0; i++) {
            if (s.charAt(i) == ' ') { // space found, word found before it
                k--;
            }
            if (k <= 0) { // first k words found
                return s.substring(0, i);
            }
        }
        return s;
    }

    public String truncateSentence2(String s, int k) {
        String ans = "";
        for (int i = 0; i < s.length() && k > 0; i++) {
            switch(s.charAt(i)) {
                case ' ': // space found, word found before it
                    k--;
                    if (k <= 0) { // first k words found
                        break;
                    }
                default:
                    ans += s.charAt(i);
            }
        }
        return ans;
    }
}
