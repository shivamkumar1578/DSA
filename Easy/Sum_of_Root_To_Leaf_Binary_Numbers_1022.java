import javax.swing.tree.TreeNode;

public class Sum_of_Root_To_Leaf_Binary_Numbers_1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int cur) {
        if (node == null) return 0;

        cur = (cur << 1) | node.val;

        if (node.left == null && node.right == null) return cur;

        return dfs(node.left, cur) + dfs(node.right, cur);
    }
}
