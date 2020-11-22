//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 828 👎 0

package Week_03;

//java:验证二叉搜索树
public class P98ValidateBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        /*public boolean isValid(TreeNode node, Integer lower, Integer upper) {
            if (node == null) return true;
            int val = node.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            if (!isValid(node.right, val, upper)) {
                return false;
            }
            if (!isValid(node.left, lower, val)) {
                return false;
            }
            return true;
        }*/

        public boolean isValid(TreeNode node, long lower, long upper) {
            if (node == null) return true;
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValid(node.left, lower, node.val) && isValid(node.right, node.val, upper);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}