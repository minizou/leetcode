public class Problem168 {
    /**
     * 168. Excel Sheet Column Title (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) (due to StringBuilder.reverse()) where n is the length of ans
     *      - Space complexity: O(n) where n is the length of the ans
     * 2. Intuition
     *      - Note how converting column numbers to Excel column titles is similar to converting from base 10 to 26:
     *          - Example: 1 is A, 26 is Z, 27 is AA, 28 is AB, etc.
     *      - Use modulo (%) and division (/) to convert each digit to its corresponding digit in base 26.
     *          - Note the edge case where the number is equal to the base (26 in base 10).
     *      - Then convert the base 26 digit to its corresponding letter using ASCII values.
     *      - Append this letter to an answer string and reverse the string in the end.
     * @param num - an integer corresponding to a column number in an Excel sheet
     * @return the corresponding column title as it appears in an Excel sheet
     */

    public String convertToTitle(int num) {
        StringBuilder ans = new StringBuilder();
        final int BASE_TYPE = 26; // base 26 where A = 1, B = 2, etc.

        while (num > 0) {
            int remainder = num % BASE_TYPE;
            num /= BASE_TYPE;
            if (remainder == 0) { // edge case
                num--; // included to not carry over extra 1 when divisible
                remainder = BASE_TYPE;
            }
            ans = ans.append(getTitleFromNum(remainder));

        }
        return ans.reverse().toString();
    }

    private String getTitleFromNum(int i) {
        if (i > 0 && i < 27) {
            // + 64 because ASCII uppercase letters start at 65
            return String.valueOf((char)(i + 64));
        }
        return null;
    }
}
