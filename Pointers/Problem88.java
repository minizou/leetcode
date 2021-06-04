public class Problem88 {
    /**
     * 88. Merge Sorted Array (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(m + n) where m, n are the number of values in nums1, nums2
     *      - Space complexity: O(m) where m is the number of values in nums1
     * 2. Intuition
     *      - Using two pointers, compare which value at the two pointers is lesser. Then move that respective
     *        pointer and repeat this process until one pointer reaches the end of an array.
     *      - Loop through any pointers that have not yet reached the end to put the remaining elements in
     *        sorted array.
     * 3. Alternative Approaches
     *      - Have the pointers start from the end of the arrays and avoid the need for a copy of nums1
     *
     * @param nums1 - integer array of length m + n
     * @param m - number of values in nums1
     * @param nums2 - integer array
     * @param n - number of values in nums2
     * Modifies nums1 to be a sorted merged array of nums1 and nums2 (non-decreasing order)
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = nums1.clone();
        int ptr1 = 0; // pointers
        int ptr2 = 0;

        while (ptr1 < m && ptr2 < n) {
            if (copy[ptr1] < nums2[ptr2]) { // ptr1 pointing at a lesser value
                nums1[ptr1 + ptr2] = copy[ptr1];
                ptr1++;
            } else { // ptr2 pointing at a lesser value
                nums1[ptr1 + ptr2] = nums2[ptr2];
                ptr2++;
            }
        }
        while (ptr1 < m) { // ptr2 reached end of array, nums1 still has items remaining
            nums1[ptr1 + ptr2] = copy[ptr1];
            ptr1++;
        }
        while (ptr2 < n) { // ptr1 reached end of array, nums2 still has items remaining
            nums1[ptr1 + ptr2] = nums2[ptr2];
            ptr2++;
        }
    }
}
