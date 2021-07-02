public class Problem1407 {
    /** 1704. Determine if String Halves Are Alike (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length() [All Methods]
     *      - Space complexity: O(1) [All Methods]
     * 2. Intuition
     *      - [Method 1] Loop through the string and use a switch statement to determine if the char being
     *        iterated through is a vowel. Keep a counter variable starting at zero.
     *           - Add +1 to the counter if it is a vowel in the first half of the string.
     *           - Add -1 if it is a vowel in the second half of a string.
     *           - Do not do anything if it is neither.
     *      - Then return whether the counter is equal to 0 (i.e, equal number of vowels in second and first half).
     *      - [Method 2] Similar logic follows. Use indexOf() to determine whether a char is a vowel instead.
     *      - [Method 3] Similar logic follows. Use a HashSet to determine whether a char is a vowel instead.
     *
     * @param s - a string of even length
     * @return true if s has the same number of vowels in its first half as in its last half; return false otherwise
     */

    // Method 1. Initial Solution
    public boolean halvesAreAlike(String s) {
        int secondHalf = s.length() / 2;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'a': // add +1 if char is a vowel
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    count += (i < secondHalf) ? 1 : -1; // 1 if in first half, -1 if in second half
            }
        }
        return (count == 0); // vowels = 0 when halves have equal number of vowels
    }

    // Method 2. Using indexOf()
    public boolean halvesAreAlike2(String S) {
        int secondHalf = S.length() / 2;
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0, j = secondHalf; i < secondHalf; i++, j++) {
            // char is in string, therefore vowel found
            if (vowels.indexOf(S.charAt(i)) >= 0) { count++; }
            if (vowels.indexOf(S.charAt(j)) >= 0) { count--; }
        }
        return (count == 0); // count = 0 when halves have equal number of vowels
    }

    // Method 3. Using HashSet
    public boolean halvesAreAlike3(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a'); // adding vowels to HashSet
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int secondHalf = s.length() / 2;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) { // vowel is found
                count += (i < secondHalf) ? 1 : -1; // 1 if in first half, -1 if in second half
            }
        }
        return (count == 0); // count = 0 when halves have equal number of vowels
    }
}
