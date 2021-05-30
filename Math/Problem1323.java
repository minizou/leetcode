public class Problem1323 {
    /**
     * 1323. Maximum 69 Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the value of num [Method 1],
     *                         O(m) where m is the number of digits in num (O(log(n) + m)) [Method 2]
     *      - Space complexity: O(1) [Method 1],
     *                          O(m) where m is the number of digits in num [Method 2]
     * 2. Intuition
     *      - The only way to maximize a number by changing its digits is to change a 6 --> 9.
     *      - [Both methods] Use modulus to get the last digit off a number and store this number.
     *        Then divide the number by 10 to get the number without the last digit.
     *      - [Method 1] Override 6s earlier in the digits of num until the first 6 is obtained. Add
     *        3 to the location of the digit of with the first 6.
     *      - [Method 2] Store the digits in an array and loop to find the first 6. Change this number to
     *        9 in the array. Then loop through the array, adding the digits together for the new number.
     * 3. Alternative Approaches
     *      - Convert to String one-liner (Integer.parseInt(("" + num).replaceFirst("6", "9"));)
     *
     * @param num - a positive integer consisting only of digits 6 and 9
     * @return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6)
     */

    // Method 1. Most straightforward solution using %
    public int maximum69Number (int num) {
        int temp = num;
        int first6 = -1; // if there are no 6s in num, first6 = -1

        for (int i = 0; temp > 0; i++) {
            if (temp % 10 == 6) { // checks if the last digit in temp is 6
                first6 = i;
            }
            temp /= 10; // takes off last digit of temp (ex: 69 --> 6)
        }
        // adds 3 to the digit with the first six (6 + 3 = 9)
        // if no six exists, (int) 10^-1 --> 0 --> num is unchanged
        return num + 3 * (int) Math.pow(10,first6);
    }

    // Method 2. My initial solution; also uses % but less straightforward
    public static int maximum69Number2 (int num) {
        int[] digits = new int[String.valueOf(num).length()];
        int index = digits.length - 1;
        int temp = 0;

        while (num > 0) { // puts digits of num into array
            temp = num % 10; // temp holds the last digit of num
            num /= 10; // takes off last digit of num
            digits[index--] = temp;
        }

        for (int i = 0; i < digits.length; i++) { // changes the first 6 in digits to 9
            if (digits[i] == 6) {
                digits[i] = 9;
                break;
            }
        }

        int newNum = 0;
        temp = digits.length - 1; // repurposes temp to act as a counter for digit placement

        for (int i = 0; i < digits.length; i++) {
            newNum += digits[i] * Math.pow(10,temp--);
        }
        return newNum;
    }
}
