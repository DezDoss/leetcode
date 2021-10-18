package leetcode.october;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree_993_18_day {
    
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

    class Solution {
        TreeNode xParent = null;
        TreeNode yParent = null;
        int xLevel = 0;
        int yLevel = 0;
        public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root, x, y, 0, null);
            return (xParent != yParent) && (xLevel == yLevel);
        }

        private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
            if(root == null) return;
            if(root.val == x) {
                xParent = parent;
                xLevel = level;
            }
            if(root.val == y) {
                yParent = parent;
                yLevel = level;
            }

            dfs(root.left, x, y, level + 1, root);
            dfs(root.right, x, y, level + 1, root);
        }
    }

    public boolean isCousins2(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode xParent = null;
        TreeNode yParent = null;
        int xDepth = 0;
        int yDepth = 0;
        int level = 0;

        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.remove();
                if(node.left != null) {
                    queue.add(node.left);
                    if(node.left.val == x) {
                        xDepth = level;
                        xParent = node;
                    } else if(node.left.val == y) {
                        yDepth = level;
                        yParent = node;
                    }
                }
                if(node.right != null) {
                    queue.add(node.right);
                    if(node.right.val == x) {
                        xDepth = level;
                        xParent = node;
                    } else if(node.right.val == y) {
                        yDepth = level;
                        yParent = node;
                    }
                }
            }
            level++;
        }

        return (xDepth != 0 && xDepth == yDepth) && (xParent != yParent);
    }
}
