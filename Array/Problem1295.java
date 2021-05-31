public class Problem1295 {
    /**
     * 1295. Find Numbers with Even Number of Digits (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n * log(m)) where n is nums.length and m is the value of the number in nums
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Loop through each number in nums and count each number's digits by dividing by 10 each time for a
     *        digit (note how numbers are in base 10 and thus dividing by 10 gets rid of the last digit of a
     *        number).
     *      - Check if the number of digits is even using % and repeat for all numbers in nums.
     * 3. Alternative Approaches
     *      - Use (Math.log10(num) + 1) in place of the digitsNum function
     *      - Convert each number in nums to a string and count the number of char in place of digitsNum
     *
     * @param nums - array of integers
     * @return how many of the integers in the array contain an even number of digits
     */

    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            if (digitsNum(num) % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    public int digitsNum(int num) { // counts number in digits in a number
        int digits = 0;
        while (num > 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }
}
