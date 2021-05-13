public class Problem1528 {
    /**
     * 1528. Shuffle String (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is indices.length
     *      - Space complexity: O(n) where n is indices.length
     * 2. Intuition
     *      - Create a new array the same size as indices and loop the characters
     *        into the new array based on their respective new position from indices[i].
     *
     * @param s - string to shuffle
     * @param indices - indices to shuffle ith char in s to position indices[i] in the shuffled string
     * @return - the shuffled string
     */

    public String restoreString(String s, int[] indices) {
        char[] sArr = new char[indices.length]; // array of shuffled char
        for (int i = 0; i < indices.length; i++) {
            sArr[indices[i]] = s.charAt(i); // shuffling the char in s based on indices[i]
        }
        return String.valueOf(sArr); // converts char array into shuffled string and returns it
    }
}
