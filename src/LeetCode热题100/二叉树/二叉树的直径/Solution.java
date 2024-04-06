package LeetCode热题100.二叉树.二叉树的直径;

/*
543. 二叉树的直径
简单
给你一棵二叉树的根节点，返回该树的 直径 。
二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
两节点之间路径的 长度 由它们之间边数表示。

示例 1：
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

示例 2：
输入：root = [1,2]
输出：1

提示：
树中节点数目在范围 [1, 104] 内
-100 <= Node.val <= 100
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
    int max_dia = 0;

    public int deep(TreeNode root){
        if (root == null) return 0;
        int ldeep = deep(root.left);
        int rdeep = deep(root.right);
        max_dia= (ldeep+rdeep) > max_dia ? (ldeep+rdeep) : max_dia;
        return Math.max(ldeep,rdeep)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int d = deep(root);
        return max_dia;

    }
}
