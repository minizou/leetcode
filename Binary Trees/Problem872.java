public class Problem872 {
    /**
     * 872. Leaf-Similar Trees (Easy)
     *
     * 1. Complexity
     *      - Time complexity: O(n) where n is the number of nodes
     *      - Space complexity: O(n) where n is the number of leaves
     * 2. Intuition
     *      - Using depth first search (dfs) to find the leaves of each tree (with a helper function),
     *        input the value of the leaves recursively into an ArrayList for both trees at the same
     *        time.
     *      - Compare the two ArrayLists and return whether they contain the same values in the same order
     *        using equals.
     * 3. Alternative Approaches
     *      - Lists, Stringbuilder, and other structures can be used in place of ArrayList
     *      - Stack implementation (Iterative solution)
     *
     * @param root1 - root of a binary tree
     * @param root2 - root of another binary tree
     * @return whether two trees with given head nodes root1 and root2 have the same leaf value sequence
     */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // base cases
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        ArrayList<Integer> leaves1 = new ArrayList<Integer>();
        ArrayList<Integer> leaves2 = new ArrayList<Integer>();

        // helper recursively calls and fills leaves1 and leaves2 with the leaves of the two roots
        helper(root1,leaves1);
        helper(root2,leaves2);

        return leaves1.equals(leaves2);
    }

    public void helper(TreeNode root,ArrayList<Integer> list) { // finds leaves of root node
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) { // end of node line aka leaf found
            list.add(root.val);
            return;
        }
        // dfs
        helper(root.left,list);
        helper(root.right,list);
    }
}
