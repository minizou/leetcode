public class Problem1832 {
    /**
     * 1832. Check if the Sentence Is Pangram (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the length of the sentence
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Since the sentence only contains lowercase English letters, if there are 26 distinct chars
     *        in the sentence, then it is a pangram.
     *      - We loop through the char in the sentence and add them to a set. Then we check if the set has
     *        26 chars.
     * 3. Alternative Approaches
     *      - Hash implementation (iterate each letter in sentence to a location in an array and iterate
     *        through the array; if an empty spot exists, then a character is missing--return false)
     *
     * @param sentence - a string containing only lowercase English letters
     * @return whether sentence is a pangram (every letter of the English alphabet appears at least once)
     */

    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i)); // if letter not yet in set, it is added
        }
        return (set.size() == 26); // false if missing a char, true if pangram
    }
}
