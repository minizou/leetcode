public class Problem344 {
    /** 344. Reverse String (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length()
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using two pointers, swap each beginning element with the last element to reverse the string. Move
     *        the pointers along after each swap.
     *      - For example: the first letter swaps with the last, the second letter in swaps with the second-to-last,
     *        the third swaps with the third-to-last, etc.
     *
     * @param s - a string of printable ASCII letters
     */

    public void reverseString(char[] s) {
        int ptrStart = 0;
        int ptrEnd = s.length - 1;
        char temp = 0;

        while (ptrStart < ptrEnd) { // the swapping
            temp = s[ptrEnd];
            s[ptrEnd--] = s[ptrStart];
            s[ptrStart++] = temp;
        }
    }
}
