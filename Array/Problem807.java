public class Problem807 {
    /** 807. Max Increase to Keep City Skyline (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(m * n) where m is grid.length and n is grid[0].length
     *      - Space complexity: O(m) where m is Math.max(grid.length,grid[0].length)
     * 2. Intuition
     *      - We are asked to find how much we can add to the values of a matrix without changing the maximum
     *        value in each row and column in the matrix. First, we find the maximum value of each row and column
     *        and keep these values in new arrays (labelled horiSkyline and vertSkyline respectively).
     *     - Then we loop through each value in the grid and add the difference between the minimum max value
     *       and the grid's existing value
     *       - Example: If a value in the grid is 3, and the largest value in its row and column are 7 and 10
     *         respectively, then we can add 7 - 3 = 4 to the value without changing what is considered the largest
     *         value in its row and column. Add this 4 to the total.
     *     - Repeat this process for all the values in the grid and return the total.
     *
     * @param grid - a square matrix where grid[i][j] represents the height of a building located there
     * @return the maximum total sum that the height of the buildings can be increased while maintaining the
     * same skyline as the original grid (same max vertical and horizontal values for the grid's rows/columns)
     */

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] vertSkyline = new int[grid[0].length];
        int[] horiSkyline = new int[grid.length];
        int vIndex = 0;
        int hIndex = 0;
        int total = 0;

        // Obtains vertical and horizontal skyline
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            int max2 = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max,grid[i][j]);
                max2 = Math.max(max2,grid[j][i]);
            }
            horiSkyline[hIndex++] = max;
            vertSkyline[vIndex++]= max2;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += Math.min(horiSkyline[i],vertSkyline[j]) - grid[i][j];
            }
        }
        return total;
    }
}
