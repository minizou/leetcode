public class Problem349 {
    /** 349. Intersection of Two Arrays (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(nlogn) where n is Math.max(nums1.length, nums2.length) [Method 1, Method 3]
     *                           - due to Arrays.sort()
     *                         O(n) where n is Math.max(nums1.length, nums2.length) [Method 2]
     *      - Space complexity: O(n) where n is Math.min(nums1.length, nums2.length)
     *                           - due to intersection answer array
     * 2. Intuition
     *      - [Method 1 & 3] Begin by sorting the arrays. Using 2 pointers on the 2 input arrays, record when
     *        the values at the pointers are the same. If one pointer has a higher value than the other, move
     *        the other pointer. This will ensure that any intersecting values will always be found.
     *      - Add the recorded intersection values (whether it be in a HashSet or modified into nums1) to the
     *        new answer array. Return this array.
     *      - [Method 2] Add one of the array's values into a set. Then loop through the second array's values,
     *        checking if they are contained within the set. If they are, an intersection is found. Add this
     *        intersecting value to a new set and return a integer array with the values of the new set.
     * 3. Alternative Approaches
     *      - Binary search approach
     *
     * @param nums1 - given integer array
     * @param nums2 - given integer array
     * @return an array of their intersection
     */


    // Method 1. Two Pointers + Sort
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0;
        int ptr2 = 0;

        // contains intersection values
        HashSet<Integer> set = new HashSet<Integer>();

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) { // intersection found
                set.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                ptr2++;
            } else { // nums1[ptr1] < nums2[ptr2]
                ptr1++;
            }
        }

        int[] ans = new int[set.size()];
        int nextIndex = 0;
        for (int val : set) {
            ans[nextIndex++] = val;
        }
        return ans;
    }

    // Method 2. First Approach/Intuitive 2 HashSets
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>(); // all nums1 values
        HashSet<Integer> intersect = new HashSet<Integer>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) { // checks if num2 value is in num1
                intersect.add(num);
            }
        }

        int[] ans = new int[intersect.size()];
        int next = 0;

        for (int value : intersect) {
            ans[next] = value;
            next++;
        }
        return ans;
    }

    // Method 3. Method 1 Modified - No HashSet
    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0;
        int ptr2 = 0;
        int next = 0; // keeps track of last intersect index inputted into num1

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                if (next == 0 || nums1[ptr1] != nums1[next - 1]) { // modifies in place instead of using HashSet
                    nums1[next] = nums1[ptr1];
                    next++;
                }
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                ptr2++;
            } else { // nums1[ptr1] < nums2[ptr2]
                ptr1++;
            }
        }

        // alternatively: use Arrays.copyOf(nums1, next)
        int[] ans = new int[next];
        for (int i = 0; i < next; i++) {
            ans[i] = nums1[i];
        }
        return ans;
    }
}
