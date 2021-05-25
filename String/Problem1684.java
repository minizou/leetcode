public class Problem1684 {
    /**
     * 1684. Count the Number of Consistent Strings (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(m*n) where m is words.length and n is words[i].length()
     *      - Space complexity: O(1) (O(26))
     * 2. Intuition
     *      - Add all the allowed char to a set.
     *      - Loop through each word and its letters, not adding to the count if a letter is not
     *        in the set (thus containing a char 'not allowed').
     * 3. Alternative Approaches
     *      - Hashmap / Hash Table implementation
     *
     * @param allowed - a string of distinct characters
     * @param words - an array of strings
     * @return the number of consistent strings in the array words (a string is consistent
     * if all characters in the string appear in the string allowed)
     */

    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        int count = 0; // solution

        for (int i = 0; i < allowed.length(); i++) { // adding allowed char to set
            set.add(allowed.charAt(i));
        }

        for (int i = 0; i < words.length; i++) { // words[i] is a word
            boolean valid = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (set.add(words[i].charAt(j)) == true) { // not allowed char is in word
                    set.remove(words[i].charAt(j));
                    valid = false;
                    break;
                }
            }
            if (valid == true) { // word only contains allowed chars
                count++;
            }
        }
        return count;
    }
}
