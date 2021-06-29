public class Problem13 {
    /** 13. Roman to Integer (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length()
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Using switch statements and going on a case-by-case basis, add the values of the roman numeral
     *        depending on the char in the string starting from the beginning of the string.
     *      - Consider the cases where knowing one letter in advance of the current letter looked at is necessary
     *        (IV, IX, XL, XC, CD, CM). Check for these cases by examining the letter at the next index (only if
     *        the char being looked at is not the last char--there is no next char after the last char!).
     * 3. Alternative Approaches
     *      - Use a hash table to map a character and its value.
     *
     * @param s - a roman numeral containing only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * @return the roman numeral converted to an integer.
     */

    public int romanToInt(String s) {
        int sum = 0; // answer

        for (int i = 0; i < s.length(); i++) {
            // note that the last char for i would make i + 1 out of index range
            boolean lastChar = (i != s.length() - 1); // false if last char in string, true if otherwise
            switch(s.charAt(i)) {
                case 'I':
                    if (lastChar && s.charAt(i + 1) == 'V') {
                        sum += 4;
                        i++; // skips the next char (V)
                    } else if (lastChar && s.charAt(i + 1) == 'X') {
                        sum += 9;
                        i++; // skips the next char (X)
                    } else { sum += 1; }
                    break;

                case 'V':
                    sum += 5;
                    break;

                case 'X':
                    if (lastChar && s.charAt(i + 1) == 'L') {
                        sum += 40;
                        i++; // skips the next char (L)
                    } else if (lastChar && s.charAt(i + 1) == 'C') {
                        sum += 90;
                        i++; // skips the next char (C)
                    } else { sum += 10; }
                    break;

                case 'L':
                    sum += 50;
                    break;

                case 'C':
                    if (lastChar && s.charAt(i + 1) == 'D') {
                        sum += 400;
                        i++; // skips the next char (D)
                    } else if (lastChar && s.charAt(i + 1) == 'M') {
                        sum += 900;
                        i++; // skips the next char (M)
                    } else { sum += 100; }
                    break;

                case 'D':
                    sum += 500;
                    break;

                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}
