public class Problem48 {
    /** 48. Rotate Image (Medium)

     * 1. Complexity
     *      - Time complexity: O(n * m) where n is matrix.length and m is matrix[0].length [Both Methods]
     *      - Space complexity: O(1) [Both Methods]
     * 2. Intuition
     *      - [Method 1] Starting from the outermost layer of the matrix, rotate every 4 values along the edges
     *        by one position (90 degrees), beginning with the first value on one side. Then rotate every other
     *        value on that side, rotating its corresponding values along the other sides of equal length.
     *      - Continue this process for every layer within the matrix.
     *
     *      - [Method 2] An image rotated by 90 degrees can be obtained by transposing a matrix and then
     *        horizontally flipping it.
     *      - Begin by transposing the matrix with a double loop. Then horizontal flip the values of each row using
     *        two pointers.
     *
     * @param matrix - an n x n 2D matrix representing an image
     * Rotates the image by 90 degrees (clockwise) in-place.
     */

    // Method 1. Rotation From Outer to Inner Layers
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int side = len; side > 1; side -= 2) { // iterates through length of side of layer
            int low = (len - side) / 2; // beginning of side
            int high = low + side - 1; // end of side

            for (int i = 0; i < side - 1; i++) { // iterating through all elements in layer
                int temp = matrix[high - i][low];
                // rotating each element in the layer
                matrix[high - i][low] = matrix[high][high - i];
                matrix[high][high - i] = matrix[low + i][high];
                matrix[low + i][high] = matrix[low][low + i];
                matrix[low][low + i] = temp;
            }
        }
    }

    // Method 2. Transpose and Horizontal Flip
    public void rotate2(int[][] image) {
        transpose(image);
        // horizontal flip
        for (int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[row].length - 1;
            while (i < j) { // horizontal flipping in row until i, j meet at middle
                int temp = image[row][i];
                image[row][i++] = image[row][j];
                image[row][j--] = temp;
            }
        }
    }
    // Turns rows into cols and vice versa
    private void transpose(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = i + 1; j < image[i].length; j++) {
                int temp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = temp;
            }
        }
    }
}
