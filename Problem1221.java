public class Problem1221 {
    /**
     * 1221. Split a String in Balanced Strings (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length()
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Loop through each char in s, adding 1 to count with 'L' char and
     *        subtracting 1 to count with 'R' char.
     *      - When count = 0, a balanced string is found; increment solution by 1
     *        and continue this process until all balanced strings are found.
     *
     * @param s - strings are those that have an equal quantity of 'L' and 'R' characters
     * @return the maximum amount of split balanced strings from s
     */

    public int balancedStringSplit(String s) {
        int solution = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                count++;
            } else { count--;}

            if (count == 0) { // balanced string is found
                solution++;
            }
        }
        return solution;
    }
}
