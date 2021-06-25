public class Problem709 {
    /** 709. To Lower Case (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is str.length()
     *      - Space complexity: O(n) where n is str.length()
     * 2. Intuition
     *      - First, identify what characters in a string are uppercase by taking advantage of ASCII order.
     *      - Similarly, use ASCII addition to find the new value in lowercase.
     * 3. Alternative Approaches
     *      - Concatenate the answer with Stringbuilder or just String rather
     *        than adjusting the char in toCharArray
     *
     * @param str - a string consisting only of printable ASCII letters
     * @return the string after replacing every uppercase letter with the same lowercase letter
     */

    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            // identifying what char are uppercase
            if ('A' <= a[i] && a[i] <= 'Z') {
                // turning char to lowercase by taking ASCII value
                a[i] = (char) (a[i] - 'A' + 'a');
            }
        }
        return new String(a);
    }
}
