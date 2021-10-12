package leetcode.com;

public class MaximumAverageSubtree_1120 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    double max = -1;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[] {0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        max = Math.max(max, 1.0 * sum / count);

        return new int[] {sum, count};
    }
}
