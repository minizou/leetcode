public class Problem66 {
    /** 66. Plus One (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is digits.length [Both Methods]
     *      - Space complexity: O(n) where n is digits.length [Both Methods]
     * 2. Intuition
     *      - [Both Methods] Start by iterating through array from the end of the array. If a digit is 9, then
     *        incrementing it by 1 will cause the digit to become 0 and the next non-9 digit to be incremented by 1.
     *      - In the case where all digits are 9 (9, 99, 999, etc.), then incrementing by 1 will increase the number
     *        of digits (and thus increase the length of the array). In other words, 9 becomes 10, 99 becomes 100, etc.
     *        - Create a new array one length in this case than the input digits array and let the first digit be 1.
     *
     * @param digits - a non-empty array of decimal digits representing a non-negative integer
     * @return an array representing the same non-negative integer incremented by one
     */

    // Method 1. Cleaner Solution
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        // start from the END of the array (i.e., 3 in 123, 5 in 9325, 9 in 39, etc.)
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits; // +1 done
            } else { // +1 gets carried to next digit, 9 becomes 0 when adding +1
                digits[i] = 0;
            }
        }
        int[] newDigits = new int[len + 1];
        newDigits[0] = 1; // first digit is always 1, others are always 0s
        return newDigits;
    }

    // Method 2. Initial Solution
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        // start from the END of the array (i.e., 3 in 123, 5 in 9325, 9 in 39, etc.)
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break; // +1 done
            } else { // +1 gets carried to next digit, 9 becomes 0 when adding +1
                digits[i] = 0;
                if (i == 0) { // case where all digits are 9s
                    int[] newDigits = new int[len + 1];
                    System.arraycopy(digits, 0, newDigits, 1, len);
                    newDigits[0] = 1;
                    return newDigits;
                }
            }
        }
        return digits;
    }
}
