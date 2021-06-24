public class Problem763 {
    /** 763. Partition Labels (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is s.length()
     *      - Space complexity: O(n) where n is s.length()
     * 2. Intuition
     *      - The requirement: Each letter in a partition must only appear in that partition.
     *        - Therefore, a partition will contain the last appearance of each letter in the partition.
     *      - Using two pointers, keep track of the location of the partition start and end. Using an int[] map,
     *        record the last instance of each letter in string by mapping a given int[] index for each letter
     *        to the index of the letter's last appearance in the input string.
     *
     *      - Loop through the string again, comparing each letter's last instance to the current partition ending.
     *        - Adjust the partition end accordingly.
     *      - Once the partition end is reached by the loop, add the size of the partition to the answer list and
     *        repeat the process, adjusting the new partition starting location.
     *
     * @param s - a string of lowercase English letters
     * @return the largest list of int representing the size of parts where each letter appears in at most one part
     */

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList();
        int[] map = new int[26]; // space for lowercase English letters
        int partEnd = 0;
        int partStart = 0;

        for (int i = 0; i < s.length(); i++) {
            // maps char letter number to last index instance of char
            map[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            partEnd = Math.max(partEnd, map[s.charAt(i) - 'a']);
            if (i == partEnd) { // reached end of partition w/o letters in it appearing later
                ans.add(i - partStart + 1); // size of partition piece
                partStart = i + 1; // next partition starting position
            }
        }
        return ans;
    }
}
