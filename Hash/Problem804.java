public class Problem804 {
    /** 804. Unique Morse Code Words (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n * m) where n is words.length and m is the average number of char in a word
     *      - Space Complexity: O(n) where n is words.length
     * 2. Intuition
     *      - Create an array containing the morse code equivalent of every lower English letter. Have the index
     *        of the array element represent the letter (0 is 'a', 1 is 'b', etc.)
     *      - Loop through words and convert each word's char into its morse code equivalent by using the array
     *        (take the char, subtract it from 'a' to use the right index; note how 'a' - 'a' = index 0).
     *      - Once the word is completely converted to morse code, add it to a HashSet.
     *        - By the nature of a HashSet, repeats will not be added.
     *      - Return the size of the HashSet.
     *
     * @param words - a list of words consisting of lowercase English letters
     * @return the number of different unique transformations among words
     */

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] { // given morse code for 26 lowercase eng letters
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---", "-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        HashSet<String> ans = new HashSet<>();
        for (String word : words) {
            String wordMorse = "";
            for (int i = 0; i < word.length(); i++) {
                wordMorse += morse[word.charAt(i) - 'a']; // adding each letter in morse code
            }
            ans.add(wordMorse); // repeat words are not added to the HashSet
        }
        return ans.size(); // size of the HashSet is # of unique words
    }
}
