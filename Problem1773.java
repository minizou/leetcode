public class Problem1773 {
    /**
     * 1773. Count Items Matching a Rule (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the indices in items
     *      - Space complexity: O(n) where n is the indices in items
     * 2. Intuition
     *      - Find the index of each list in items being looked at from ruleKey
     *      - Loop through each list in items and update count based on ruleValue
     *      - Return the count of the number of matching elements
     * 3. Alternative Approaches
     *      - Using Map.of()
     *
     * @param items items[i] = [type_i, color_i, name_i]
     * @param ruleKey type, color, or name
     * @param ruleValue desired value at ruleKey index for each item in list
     * @return the number of items that match the given rule
     */

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int keyIndex = -1;

        // finds index to be checked in each list in items
        switch(ruleKey) {
            case "type":
                keyIndex = 0;
                break;
            case "color":
                keyIndex = 1;
                break;
            case "name":
                keyIndex = 2;
                break;
        }

        // iterates through item lists and increments count if there is a match
        for (List<String> i: items) {
            if (i.get(keyIndex).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
