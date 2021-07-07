import java.util.*;

public class Problem1207 {
    /** 1207. Unique Number of Occurrences (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is arr.length
     *      - Space complexity: O(n) where n is arr.length
     * 2. Intuition
     *      - Use a HashMap to keep track of the number of occurrences for each value in arr.
     *      - Then iterate through the values of the HashMap and add them to a set. If one item is already
     *        in the set, then a non-unique number of occurrences was found. Return false.
     *        - Otherwise, return true.
     *
     * @param arr - an array of int values
     * @return true if and only if the number of occurrences of each value in the array is unique
     */

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); // maps num : num of occurences for that num
        HashSet<Integer> unique = new HashSet<Integer>(); // keeps track of unique number of occurences
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],1);
            } else { // adding 1 to occurrences for that number
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        for (int num : map.values()) {
            if (!unique.add(num)) { // non-unique occurrence value found
                return false;
            }
        }

        return true;
    }
}
