public class Problem1732 {
    /**
     * 1732. Find the Highest Altitude (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is gain.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Keep track of the running height sum and update maxHeight if
     *        height > maxHeight at any point.
     *
     * @param gain - altitude gains
     * @return highest altitude
     */

    public int largestAltitude(int[] gain) {
        int height = 0; // current altitude
        int maxHeight = 0; // solution
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }
}
