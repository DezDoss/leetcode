package leetcode.com;

public class CountNodesEqualtoSumofDescendants_1973 {

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

    int count = 0;
    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return count;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = dfs(root.left) + dfs(root.right);
        if(sum == root.val) {
            count++;
        }

        return sum + root.val;
    }
}
