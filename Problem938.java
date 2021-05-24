public class Problem938 {
    /**
     * 938. Range Sum of BST (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the total number of nodes
     *      - Space complexity: O(n) where n is the total number of nodes
     * 2. Intuition
     *      - Recursively go through all the nodes in the tree, and continue traversing through the tree until
     *        reaching the end of a branch or a valid node in the range.
     *      - If the value of the node is not in range, traverse only one side of the node depending on its value.
     *      - Include the value of the valid node in the sum and continue traversing the tree until the entire
     *        tree is traversed.
     * 3. Alternative Approaches
     *      - Iterative solution using Stacks
     *      - Morris traversal (* not yet checked)
     *
     * @param root - root node of a binary search tree
     * @param low - lower value bound
     * @param high - upper value bound
     * @return the sum of values of all nodes with a value in the inclusive range [low, high]
     */

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) { // base case
            return 0;
        }
        if (root.val < low) { // left not in range
            return rangeSumBST(root.right,low,high);
        }
        if (root.val > high) { // right not in range
            return rangeSumBST(root.left,low,high);
        }
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
}
