public class Problem832 {
    /** 832. Flipping an Image (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(m * n) where m is image.length and n is image[0].length [Both Methods]
     *      - Space complexity: O(m * n) where m is image.length and n is image[0].length [Method 1],
     *                          O(1) [Method 2]
     * 2. Intuition
     *      - [Method 1] Loop through each element in the matrix, adding them to a new matrix in reverse order per row and
     *        changing their value ( 0 --> 1, 1 --> 0)
     *      - [Method 2] Note how, if the value of an element and where it will be flipped to are not the same,
     *        then their flipped and inverted values will be the same as the original values:
     *              0 1  <-- original values
     *              1 0  <-- flipped horizontally
     *              0 1  <-- inverted values
     *      - Thus we only need to change elements and the location they'll be flipped to if the two values are
     *        the same. Invert these values.
     *
     * @param image - an n x n binary matrix
     * @return the image flipped horizontally and inverted
     */

    // Method 1. Initialize New Image Solution
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans =  new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                // the inverting and flipping
                if (image[i][j] == 1) {
                    ans[i][image[i].length - j - 1] = 0;
                } else {
                    ans[i][image[i].length - j - 1] = 1;
                }
            }
        }

        return ans;
    }

    // Method 2. Change Image In Place Solution
    public int[][] flipAndInvertImage2(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j * 2 < image.length; j++) {
                // element and where it will flip to are the same
                if (image[i][j] == image[i][image.length - j - 1]) {
                    // inverting portion
                    if (image[i][j] == 1) {
                        image[i][j] = 0;
                        image[i][image.length - j - 1] = 0;
                    } else {
                        image[i][j] = 1;
                        image[i][image.length - j - 1] = 1;
                    }
                }
            }
        }
        return image;
    }
}
