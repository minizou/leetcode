public class Problem557 {
    /** 557. Reverse Words in a String III (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length() [Both Methods] [Note: Method 1 is O(2 * n), 2 is O(n)]
     *      - Space complexity: O(n) where n is s.length() [Both Methods] [Note: Method 1 is O(n), 2 is O(3 * n)]
     * 2. Intuition
     *      - [Method 1] Using two pointers, reverse each individual word by swapping the beginning of each letter to
     *        its corresponding distance to the end of the word (first letter swaps with the last letter, second swaps
     *        with the second-to-last, etc.). Move the pointers to keep track of the next letter to be swapped.
     *      - Note how a word is found either before a space or at the end of the string. Return the string version
     *        of the adjusted array.
     *      - [Method 2] Concatenate the letters in reverse, keeping original word order by adding each reversed word
     *        and a space to the end of another string. Get rid of the last space at the end of this answer string
     *        and return it.
     *
     * @param s - a string containing printable ASCII characters
     * @return the string with each word reversed while still preserving whitespace and initial word order.
     */

    // Method 1. Array-Focused version of Method 1
    public String reverseWords(String s) {
        int wordStart = 0;
        int wordEnd = 0;
        char temp;
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ' || i == str.length - 1) {   // word is found before space or at end of string
                if (i < str.length - 1) { // word before space
                    wordEnd = i - 1;
                } else { // end of string word
                    wordEnd = i;
                }
                while (wordStart < wordEnd) { // reversing the individual word
                    temp = str[wordEnd];
                    str[wordEnd--] = str[wordStart];
                    str[wordStart++] = temp;
                }
                wordStart = i + 1; // starting char of next word
            }
        }
        return new String(str);
    }

    // Method 2. Initial Solution
    public String reverseWords2(String s) {
        String word = "";
        String ans = "";
        char[] str = s.toCharArray();

        for (int i = str.length - 1; i > -1; i--) {
            if (str[i] != ' ') {
                word += str[i]; // reversing letters of word
            } else { // space found, word is done
                ans = word + " " + ans;
                word = "";
            }
        }
        ans = word + " " + ans; // adding the last word to be reversed
        return ans.substring(0, ans.length() - 1); // getting rid of space at the end and returning
    }
}
