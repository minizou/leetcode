public class Problem278 {
    /**
     * 278. First Bad Version (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n))
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use binary search the find the first instance of a bad version.
     *      - Let n = 3 where 2 is the first bad. Let - denote low, + denote high, and * denote mid:
     *      - [Method 1] Loop until low > high, let high = mid - 1:
     *        1-   2*  3+  -->  1-+ 2*  3
     *        1-*+ 2   3   -->  1*+ 2-  3 --> low > high --> return 2
     *      - [Method 2] Loop until low >= high, let high = mid (mid included in range):
     *        1-   2*  3+  -->  1-  2*+ 3
     *        1-*  2+  3   -->  1*  2-+ 3 --> low = high --> return 2
     */

    // Method 1. Initial Solution
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) { // mid is bad
                high = mid - 1;
            } else { // mid is good
                low = mid + 1;
            }
        }
        return low;
    }

    // Method 2. Slight variation
    public int firstBadVersion2(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) { // mid is bad
                high = mid;
            } else { // mid is good
                low = mid + 1;
            }
        }
        return low;
    }
}
