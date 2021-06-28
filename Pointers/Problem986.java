public class Problem986 {
    /** 986. Interval List Intersections (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is lst1.length() + lst2.length
     *      - Space complexity: O(n) where n is lst1.length() + lst2.length
     * 2. Intuition
     *      - Using a somewhat similar approach to that of mergesort, we need to:
     *        - find the intersection between two given intervals;
     *        - find a way to discern the next two intervals to be compared.
     *      - Using two pointers, loop through both lst1 and lst2 to cover all the possible intersections.
     *      - Find the intersection interval of two given intervals by obtaining the maximum minimum value and
     *        the minimum max value:
     *        - Note how the intersection of [4,10] and [6,17] is [max min value, min max value] = [6,10].
     *      - Move the pointers depending on which interval has a smaller maximum value.
     *
     * @param lst1 - a list of closed intervals that are pairwise disjoint and in sorted order
     * @param lst2 - another list of closed intervals that are pairwise disjoint and in sorted order
     * @return the intersection of these two interval lists
     */

    public int[][] intervalIntersection(int[][] lst1, int[][] lst2) {
        List<int[]> ans = new ArrayList<>();
        int ptr1 = 0; // pointer in lst1
        int ptr2 = 0; // pointer in lst2

        while (ptr1 < lst1.length && ptr2 < lst2.length) {
            int min = Math.max(lst1[ptr1][0],lst2[ptr2][0]); // maximum min value (min value intersection)
            int max = Math.min(lst1[ptr1][1],lst2[ptr2][1]); // minimum max value (max value intersection)
            if (min <= max) { // valid intervals only (ensures to not have intervals like (13,12))
                ans.add(new int[]{min, max});
            }

            // determines next intervals to compare based on possible intersections
            if (lst1[ptr1][1] < lst2[ptr2][1]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
