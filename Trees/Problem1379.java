public class Problem1379 {
    /**
     * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree (Medium)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of nodes in the tree
     *      - Space complexity: O(n) where n is the max height of the tree
     * 2. Intuition
     *      - Using depth first search (DFS), traverse all the nodes in both trees at the same time by traversing
     *        the left and right subtrees.
     *      - Since both the original and cloned trees are traversed together, when the target is found in
     *        the original, returning the cloned node will also point to the same location in the cloned tree.
     *
     * @param original - binary tree containing the node target
     * @param cloned - a copy of original
     * @param target - a node in the original tree
     * @return a reference to the same node in the cloned tree
     */

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target || original == null) { // base case when target is found
            return cloned; // solution
        } else { // DFS
            TreeNode node = getTargetCopy(original.left,cloned.left,target); // traverse left subtree
            if (node == null) { // tree not in left subtree
                node = getTargetCopy(original.right,cloned.right,target); // traverse right subtree
            }
            return node;
        }
    }
}
