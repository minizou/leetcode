public class Problem1374 {
    /** 1374. Generate a String With Characters That Have Odd Counts (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the value of the input n
     *      - Space complexity: O(n) where n is the value of the input n
     * 2. Intuition
     *      - If n is odd, then all that needs to be returned is a string of length n consisting of 1 letter.
     *      - If n is even, then return a string of length n consisting of 1 letter repeated n - 1 times added to
     *        a single other letter.
     * @param n - an integer value
     * @return a string with n characters such that each character in such string occurs an odd number of times
     */

    public String generateTheString(int n) {
        StringBuilder str = new StringBuilder();
        int length = n % 2 == 0 ? n - 1 : n; // determines length of first letter
        for (int i = 0; i < length; i++) {
            str.append('a');
        }
        if (n % 2 == 0) { // second letter necessary if n is even
            str.append('b');
        }
        return str.toString();
    }
}
