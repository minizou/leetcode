public class Problem104 {
    /**
     * 104. Maximum Depth of Binary Tree (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of nodes
     *      - Space complexity: O(n) where n is the number of nodes
     * 2. Intuition
     *      - [Method 1] Using a stack, track the depth of a node by pushing the depth each time a node
     *        is pushed (thus going deeper in the node line). At the end of the node line, set the depth to
     *        max if it is greater than the current max. Repeat this for all node lines in the binary tree.
     * 3. Alternative Approaches
     *      - BFS Iterative Method
     *
     * @param root - root of a binary tree
     * @return the maximum depth of the binary tree
     */

    // Method 1. Iterative Solution
    public int maxDepth(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();

        int max = 0;
        int depth = 1;

        while (node != null || !nodeStack.isEmpty()) { // iterating through all nodes in tree
            if (node != null) {
                nodeStack.push(node);
                depthStack.push(depth);
                node = node.left;
                depth++;
            } else { // node is null - cannot go further left
                node = nodeStack.pop();
                depth = depthStack.pop();

                if (depth > max) { // end of node line
                    max = depth;
                }

                node = node.right;
                depth++;
            } // finished traversing the tree
        }
        return max;
    }

    // Method 2. Recursive Solution
    public int maxDepth2(TreeNode root) {
        if (root == null) {  // base case
            return 0;
        } else { // exists
            return 1 + (int) Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
