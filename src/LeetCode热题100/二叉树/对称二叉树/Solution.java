package LeetCode热题100.二叉树.对称二叉树;
/*
101. 对称二叉树
简单
给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true

示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false

提示：
树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100

进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }


    public boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else return p.val==q.val && check(p.left,q.right) && check(p.right,q.left);
    }

}
