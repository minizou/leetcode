public class Problem9 {
    /** 9. Palindrome Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the value of x [Both Methods]
     *      - Space complexity: O(1) [Method 1]
     *                          O(log(n)) where n is the value of x [Method 2]
     * 2. Intuition
     *      - [Method 1] Reverse half the number and compare where the first half and the latter half are equal.
     *        If they are, then the number is a palindrome.
     *      - Using modulo (%) to take off the last digit of x, obtain the latter reversed half of the number.
     *        See Problem 7 for more in-depth detail on how the reversal works.
     *      - Compare the halves and return whether they are equal.
     *      - [Method 2] Using modulo, obtain the number of digits in the number. Then create an array for each
     *        digit. Using two pointers (start and end), iterate through the digit array and return false if
     *        two numbers do not match.
     * 3. Alternative Approaches
     *      - Use string manipulation check if a given number is a palindrome.
     *
     * @param x - a 32-bit given integer
     * @return true if x is palindrome integer
     */

    // Method 1. Solution using Reversed Number
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0) && (x != 0)) { // base cases
            return false;
        }

        int xReversed = 0; // reversed number from the latter half

        while (x > xReversed) { // obtaining the latter half
            xReversed = xReversed * 10 + x % 10;
            x = x / 10;
        }
        // the first / 10 is for cases of odd num of digits (ex. 131 --> left half: 1, right half: 13)
        // the second portion is for cases of even num of digits (ex. 11 --> left half: 1, right half: 1)
        return (x == xReversed / 10 || x == xReversed); //
    }

    // Method 2. Initial Solution
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int numDigits = 0;
        int temp = x;

        // obtaining the number of digits in x
        while (temp > 0) {
            numDigits++;
            temp /= 10;
        }

        int[] digits = new int[numDigits];
        int next = 0;

        // putting digits in digit array
        while (x > 0) {
            digits[next++] = x % 10;
            x /= 10;
        }

        // checking if opposite digits are equal (aka palindrome)
        for (int start = 0, end = digits.length - 1; start < end; start++, end--) {
            if (digits[start] != digits[end]) {
                return false;
            }
        }
        return true;
    }
}
