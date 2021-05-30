public class Problem1828 {
    /**
     * 1. 1828. Queries on Number of Points Inside a Circle (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n*m) where n is queries.length and m is points.length
     *      - Space complexity: O(n) where n is queries.length
     * 2. Intuition
     *      - Using a brute-force method, we check if each point in points is in each query circle (double loop).
     *      - Note that by the distance formula,  For a point to be inside a circle,
     *        the euclidean distance between it and the circle's center needs to be les
     *        than or equal to the radius.
     *      - Keep track of the count of the number of points in each circle and input it in the answer array.
     * 3. Alternative Approaches
     *      - [NOT YET ATTEMPTED] Binary Search + Sort Solution
     *
     * @param points - points[i] = [x_i, y_i] is the coordinates of the ith point on a 2D plane
     * @param queries - queries[j] = [x_j, y_j, r_j] describes a circle centered at (x_j, y_j) with a radius of r_j
     * @return an array where answer[j] is the number of points inside/on the jth circle in queries
     */

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] circle : queries) { // for each query [x,y,radius]
            int count = 0;
            int radSqr = (int) circle[2] * circle[2];
            for (int[] point : points) { // for each point [x,y]
                int distance = (circle[0] - point[0]) * (circle[0] - point[0])
                        + (circle[1] - point[1]) * (circle[1] - point[1]);
                if (distance <= radSqr) {
                    count++;
                }
            }
            answer[index++] = count;
        }
        return answer;
    }
}
