public class Problem11 {
    /** 11. Container With Most Water (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where is n is height.length [Method 1]
     *                         O(n^2) where n is height.length [Method 2]
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - We are being asked to find the max possible area.
     *        - The height of a given container is the smaller line of the two vertical lines on the container.
     *        - The width of a given container is the distance between the two lines (the difference
     *        of their indices).
     *      - Note how the smaller line is always the limiting factor for the height.
     *        - We will thus only be ever changing this limiting factor in the hopes that the next line is possibly
     *          greater in length, changing the limiting factor to be greater.
     *        - This in turn only accounts for possible increases in max area.
     *      - Using two pointers, compare two vertical lines (starting from the beginning and end of the
     *        array) and move the pointer with the smallest value. Record the area each time.
     *      - Continue this process until the pointers meet/cross, indicating that all possibilities have
     *        been checked.
     *
     * @param height - an array of vertical lines
     * @return the maximum possible area to hold water created by two vertical lines.
     */

    public int maxArea(int[] height) {
        int ptr1 = 0; // beginning of array
        int ptr2 = height.length - 1; // end of array
        int area = 0; // area of given container
        int areaMax = 0;

        while (ptr1 < ptr2) {
            area = Math.min(height[ptr1], height[ptr2]) * (ptr2 - ptr1);
            areaMax = Math.max(areaMax, area);

            if (height[ptr1] < height[ptr2]) { // ptr1 is pointing at limiting factor line
                ptr1++;
            } else { // ptr2 is pointing at limiting factor line
                ptr2--;
            }
        }
        return areaMax;
    }
}
