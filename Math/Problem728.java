public class Problem728 {
    /**
     * 728. Self Dividing Numbers (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n * log(m)) where n is the number of int within the bound [left,right]
     *                         and m is the number of digits in the largest int in the range
     *      - Space complexity: O(n) where n is the number of int within the lower and upper bound [left,right]
     * 2. Intuition
     *      - Loop through each integer in the bound [left,right].
     *      - Using %, loop through each digit in each integer. Note how self dividing numbers
     *        are not allowed to contain 0 or contain a digit it is not divisible by.
     *      - If all digits satisfy this condition in the integer, add it to the list. Repeat for the other integers
     *        in the bound.
     *
     * @param left - lower integer bound
     * @param right - upper integer bound
     * @return a list of every possible self dividing number within the bound
     */

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> solution = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            int digit = 0;
            int num = i;
            boolean valid = true; // determines whether number is self dividing

            while (num > 0) {
                digit = num % 10; // gets last digit off number
                num /= 10; // takes last digit off of number (ex: 351 --> 35)
                if (digit == 0 || i % digit != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) { // adds self dividing number into solution list
                solution.add(i);
            }
        }
        return solution;
    }
}
