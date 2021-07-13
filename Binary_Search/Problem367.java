public class Problem367 {
    /** 367. Valid Perfect Square (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(log(n)) where n is nums.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Use binary search. Let the high value be the input value and the low value be 1. Keep adjusting these
     *        values until the middle of these two values is closest to that of the square root of x.
     *      - If the middle value ever reaches exactly the square root of x, return true. Else return false.
     * 3. Alternative Approaches
     *
     * @param num - an integer value
     * @return true if num is a perfect square else false (do not use any built-in library function such as sqrt)
     */

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == num / mid && num % mid == 0) { // checks if mid is exactly square root
                return true;
            } else if (num / mid > mid) {
                low = mid + 1; // sqrt between [mid+1,high]
            } else {
                high = mid - 1; // sqrt between [low,mid-1]
            }
        }
        return false;
    }
}
