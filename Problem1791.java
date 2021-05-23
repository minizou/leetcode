public class Problem1791 {
    /**
     * 1791. Find Center of Star Graph (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(1)
     *      - Space complexity: O(1)
     * 2. Intuition
     *      - Since there is no node between the edge and the center node, then the first two
     *        edges must share a center node. Simply check to see which of the indices in the
     *        first two edges in match. If they match, it's the center node.
     *
     * @param edges - 2D integer array where each edges[i] = [u_i, v_i] indicates that there is an edge
     *                between the nodes u_i and v_i
     * @return the center of the given star graph
     */

    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0]; // first index is matching
        } else {
            return edges[0][1]; // second index must be center if not first
        }
    }
}
