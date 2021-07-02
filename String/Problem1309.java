public class Problem1309 {
    /** 1309. Decrypt String from Alphabet to Integer Mapping (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is is s.length()
     *      - Space complexity: O(n) where n is s.length()
     * 2. Intuition
     *      - Loop through the char of s. Check to see if a # exists two char in advance of the current char
     *        being looped through.
     *      - Taking advantage of ASCII values, take the two values before the char and manipulate them such
     *        that they map to their letter values. Then skip to after the # and continue looping.
     *      - If a # is not found two char in advance, then the possible letters for the char are ('a' to 'i').
     *        Map the char value accordingly.
     * @param s - a string formed by digits ('0' - '9') and '#'
     * @return the string formed after mapping where ('a' to 'i') are represented by ('1' to '9') respectively
     * and  ('j' to 'z') are represented by ('10#' to '26#') respectively
     */

    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') { // 10# to 26# mapping found
                int value = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                ans.append( (char) ('j' + value - 10) ); // note: j --> 10#
                i += 2;
            } else {
                ans.append( (char) ('a' + s.charAt(i) - '1') ); // note: a --> 1
            }
        }
        return ans.toString();
    }
}
