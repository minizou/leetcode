public class Problem695 {
    /**
     * 695. Max Area of Island (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n * m) where n is grid.length and m is grid[0].length
     *      - Space complexity: O(n * m) here n is grid.length and m is grid[0].length
     * 2. Intuition
     *      - Create a boolean array of the same size to keep track of which cells in the grid have been visited.
     *      - Iterate through each cell in the grid. If the cell hasn't been visited yet and is an island, then
     *        count the area of that island using depth-first search (dfs).
     *          - dfs recursively calls on its adjacent cells, marking cells as visited and counting them towards
     *            the area as it calls itself.
     *      - Check if the area is greater than the current maxArea. If it is, update maxArea accordingly.
     *      - Repeat this process until all cells (and thus islands) are visited to obtain the true max area.
     * 3. Alternative Approaches
     *      - Breadth-first search (bfs) approach
     *
     * @param grid - a binary matrix where an island is a group of 1's connected 4-directionally (0's are water)
     * @return the maximum area of an island in grid. If there is no island, return 0
     */

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // keeps track of what cells have been visited
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) { // unvisited island found
                    int area = dfs(grid, visited, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    // checks if neighbor exists and is an unvisited island
    public boolean isValid(int[][] grid, boolean[][] visited, int row, int col) {
        if ((row < 0) || (col < 0)
                || (row >= grid.length) || (col >= grid[0].length)
                || (grid[row][col] != 1) || (visited[row][col])) {
            return false;
        } else { return true; }
    }

    // modifies visitStatus, returns area
    public int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (isValid(grid,visited,row,col) == false) {
            return 0;
        }

        int area = 1;
        visited[row][col] = true; // marks element as visited

        area += dfs(grid,visited,row,col - 1); // left neighbor
        area += dfs(grid,visited,row,col + 1); // right neighbor
        area += dfs(grid,visited,row - 1,col); // above neighbor
        area += dfs(grid,visited,row + 1,col); // below neighbor

        return area;
    }
}
