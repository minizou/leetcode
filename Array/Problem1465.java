public class Problem1465 {
    /**
     * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
     *
     * 1. Complexity
     *      - Time complexity: O(n log(n)) (from .sort) where n is the number of cuts in hCuts and vCuts
     *      - Space complexity: O(h + v) where h is hCuts.length and v is vCuts.length
     * 2. Intuition
     *      - Sort both hCuts and vCuts so that they are in ascending order. This way, cuts closest to each other
     *        are directly beside each other in the array (and the difference between them can be easily calculated).
     *      - Note how the biggest horizontal length between cuts multiplied by the biggest vertical length
     *        between cuts results in the maximum area.
     *      - Loop through both hCuts and vCuts, comparing every two values until the max horizontal difference
     *        and vertical difference is found.
     *      - Convert the answer to a long and % 1000000007 as the problem states to do for the sake of
     *        large number constraints.
     *
     * @param h - height of rectangular cake
     * @param w - width of rectangular cake
     * @param hCuts - hCuts[i] is the distance from the top of the rectangular cake to the ith
     * @param vCuts - vCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut
     * @return the maximum area of a piece of cake after you cut at each horizontal and vertical position
     *         provided in the arrays horizontalCuts and verticalCuts
     */

    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        int hMax = Math.max(hCuts[0], h - hCuts[hCuts.length - 1]); // calculates max diff of the horizontal edges
        int vMax = Math.max(vCuts[0], w - vCuts[vCuts.length - 1]); // calculates max diff of the vertical edges

        for (int i = 0; i < hCuts.length - 1; i++) { // comparing differences between horizontal edges
            int diff = hCuts[i + 1] - hCuts[i];
            if (diff > hMax) {
                hMax = diff;
            }
        }

        for (int i = 0; i < vCuts.length - 1; i++) {  // comparing differences between vertical edges
            int diff = vCuts[i + 1] - vCuts[i];
            if (diff > vMax) {
                vMax = diff;
            }
        }
        long ans = (((long) hMax * (long) vMax) % 1000000007);
        return (int) ans;
    }
}
