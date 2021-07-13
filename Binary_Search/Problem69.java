public class Problem69 {
    /** 69. Sqrt(x) (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n))
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use binary search to find the square root value.
     *      - Let the high value be the input value and the low value be 1. Keep adjusting these
     *        values until the middle of these two values is closest to that of the square root of x.
     * 3. Alternative Approaches
     *      - Newton Method
     *      - Brute Force Method
     *
     * @param x - a non-negative integer
     * @return the square root of the integer without using built-in functions such as pow(x, 0.5) or x ** 0.5
     */

    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        while (low <= high) { // until closest value to sqrt is found
            int mid = low + ((high - low) / 2);
            if (mid == x / mid) { // exact square root found
                return mid;
            } else if (mid > x / mid) { // actual square root value is between [low, mid - 1]
                high = mid - 1;
            } else { // mid * mid < x
                low = mid + 1;
            }
        }
        return high;
    }
}
