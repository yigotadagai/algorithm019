//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 403 👎 0

package Week_03;

//java:二叉树的最小深度
public class P111MinimumDepthOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//Definition for a binary tree node.
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }
    class Solution {
        public int minDepth(TreeNode root) {
/*
            //terminal
            if (root == null) return 0;
            //process current logic
//            if (root.left == null && root.right == null) return 1;
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            //drill down
//            if (root.left == null || root.right == null) return leftHeight + rightHeight +1;
            //restore current status
//            return Math.min(leftHeight, rightHeight) + 1;
            return root.left == null || root.right == null
                    ? leftHeight + rightHeight + 1
                    : Math.min(leftHeight, rightHeight) + 1;
*/

            //DFS
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int ans = Integer.MAX_VALUE;
            if (root.left != null) {
                ans = Math.min(minDepth(root.left), ans);
            }
            if (root.right != null) {
                ans = Math.min(minDepth(root.right), ans);
            }
            return ans + 1;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}