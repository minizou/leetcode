public class Problem904 {
    /** 904. Fruit Into Baskets (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is trees.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - We are essentially being asked to find the longest contiguous subarray in trees with a maximum of
     *        2 unique int values.
     *      - Loop through trees and keep track of the previous two unique types looked at at each point.
     *        Increment the total as these two fruit types are contiguously found.
     *      - When a third unique type is found, update the total to only include the most recent type
     *        and the third unique type. These two types are now the most recent fruit types examined. This is
     *        essentially the next different subarray.
     *      - Continue until the maximum total of all of these subarray totals are found.
     * 3. Alternative Approaches
     *      - Sliding window approach
     *
     * @param trees - a row of trees where the i-th tree produces fruit with its type represented by an int value
     * @return the maximum total amount of fruit that can be collected contiguously with a maximum of 2 unique fruits
     */

    public int totalFruit(int[] trees) {
        int fruit1 = -1; // last/most recent fruit type looked at
        int fruit2 = -1; // second to last fruit type looked at
        int fruit1Count = 0;
        int total = 0;
        int maxTotal = 0;

        for (int fruit : trees) {
            if (fruit == fruit1 || fruit == fruit2) {
                total++;
            } else {
                // 3rd fruit type found; 2 types considered are now 3rd and the previous fruit type (fruit1)
                // rather than the previous fruit type (fruit1) and the second to last fruit type (fruit2)
                total = fruit1Count + 1; // new total updates to fruit1Count and 1 for the new 3rd type
            }

            // counting # of continuous fruit1
            if (fruit == fruit1) {
                fruit1Count++;
            } else { fruit1Count = 1; }

            if (fruit != fruit1) { // fruit1 is no longer the last/most recent fruit type looked at
                fruit2 = fruit1;
                fruit1 = fruit;
            }
            maxTotal = Math.max(total,maxTotal);
        }
        return maxTotal;
    }
}
