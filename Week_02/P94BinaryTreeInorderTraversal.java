//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 773 👎 0

package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//java:二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args){
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
//Solution
class Solution {
    //recursion
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }*/


    //iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                root = temp.right;
            }
        }
        return res;
    }

    /*//color solution
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.empty()) {
            ColorNode cn = stack.pop();

            if (cn.color.equals("white")) {
                if (cn.node.right != null) stack.push(new ColorNode(cn.node.right, "white"));
                stack.push(new ColorNode(cn.node, "gray"));
                if (cn.node.left != null) stack.push(new ColorNode(cn.node.left, "white"));
            } else {
                res.add(cn.node.val);
            }
        }

        return res;
    }*/

     /*//color reduction
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            Object e = stack.pop();
            if (e == null) {
                continue;
            }
            if (e instanceof TreeNode) {
                // 前序遍历（根 、左、右），要做 逆序 入栈
                stack.add(((TreeNode) e).right);
                stack.add(((TreeNode) e).val);
                stack.add(((TreeNode) e).left);
            } else if (e instanceof Integer) {
                list.add((Integer) e);
            }
        }

        return list;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}