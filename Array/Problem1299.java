public class Problem1299 {
    /** 1299. Replace Elements with Greatest Element on Right Side (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is arr.length
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Loop through the array backwards and keep track of the maximum value. Replace each iterated element
     *        with the maximum (except the last, which is replaced by -1) and update the max as needed.
     *
     * @param arr - an array of int values
     * @return arr after replacing every element in that array with the greatest element among the elements to its
     * right, and with the last element as -1.
     */

    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i > -1; i--) {
            int temp = max;
            if (arr[i] > max) {
                max = arr[i];
            }
            arr[i] = temp;
        }
        return arr;
    }
}
