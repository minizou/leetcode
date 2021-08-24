public class Problem171 {
    /**
     * 171. Excel Sheet Column Number (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the length of columnTitle
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Note how converting Excel column titles to column numbers is similar to converting from base 26 to 10:
     *          - Example: A is 1, AA is 27, etc.
     *      - Convert each char in columnTitle to its corresponding base-26 int value using ASCII values.
     *      - Then convert the value into its base 10 equivalent and add it to a sum.
     *      - Return the answer sum once all the char in the columnTitle have been looped through.
     * @param columnTitle - a string of uppercase English letters representing a column title in Excel sheet
     * @return the corresponding column number
     */

    public int titleToNumber(String columnTitle) {
        // loops through each char in string
        final int OG_BASE_NUM = 26;

        int ans = 0;
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            int num = getNumFromTitle(columnTitle.charAt(i)); // getting base-26 int value for char
            ans += num * Math.pow(OG_BASE_NUM, len - i - 1); // converting to base 10
        }
        return ans;
    }

    private int getNumFromTitle(char c) {
        // uppercase ASCII letters start at 65
        // A is 65, B is 66, etc.
        return (int) c - 64;
    }
}
