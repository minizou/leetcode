public class Problem7 {
    /** 7. Reverse Integer (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the value of the input x
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use modulus (%) to get the last digit of a given number. Add this digit to the current answer and later
     *        multiply it by 10 to increase the amount of digits in the number (0 --> tens --> hundreds, etc.). Divide
     *        by 10 to receive the number without the digit (so you do not count the same digit multiple times).
     *      - To account for overflow without using 65-bit integers (like longs), also keep track of the previous
     *        value before doing the operation explained above. After adding the digit and using modulus, check if
     *        the new value for the answer is the same as the previous value for the answer.
     *          - If not, overflow has occurred. Return 0 as the problem requires.
     *
     * @param x - a signed 32-bit integer
     * @return x with its digits reversed (return 0 if reversing x causes
     * the value to go outside the signed 32-bit integer range) without using 64-bit integers
     */

    public int reverse(int x) {
        int lastAns = 0; // to keep track of overflow
        int ans = 0;
        while (x != 0) {
            int digit = x % 10;
            ans = (ans * 10) + digit;
            if ((ans - digit) / 10 != lastAns) { // overflow found
                return 0;
            } else {
                lastAns = ans;
                x /= 10; // gets rid of last digit
            }
        }
        return ans;
    }
}
