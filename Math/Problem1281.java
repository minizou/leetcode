public class Problem1281 {
    /** 1281. Subtract the Product and Sum of Digits of an Integer (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is the inputted number n (log_10(n)) [Method 1],
     *        O(n) where n is the number of digits in the inputted number [Method 2]
     *      - Space complexity: O(1) [Both methods]
     * 2. Intuition
     *      - [Method 1] Use modulus to get the last digit off a number. Then divide the number by 10 to get
     *        the number without the last digit.
     *      - [Method 2] Turn the integer value into a String. Since the char of the string are the number's
     *        digits, get the numeric value of the string's char.
     *      - [Both methods] Multiply this digit by the product and add it to the sum.
     *        Repeat this until all digits are obtained and return the (product - sum).
     *
     * @param n - a given integer
     * @return the difference between the product of its digits and the sum of its digits
     */

    // Method 1. Getting Digits Using %
    // Does not work for negative integers, but the problem constraints mention
    // 1 <= n <= 10^5 so this is not a problem in this case.
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10; // gets last digit off number (ex: 640 --> 64)
        }
        return (product - sum);
    }

    // Method 2. Getting Digits from String Values
    public int subtractProductAndSum2(int n) {
        String num = String.valueOf(n);
        int product = 1;
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            sum += Character.getNumericValue(num.charAt(i));
            product *= Character.getNumericValue(num.charAt(i));
        }
        return (product - sum);
    }
}
