package LeetCode热题100.二叉树.二叉树的最大深度;
/*
104. 二叉树的最大深度
简单
给定一个二叉树 root ，返回其最大深度。
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：3

示例 2：
输入：root = [1,null,2]
输出：2

提示：
树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
 */
public class Solution {

    //方法一：会用到全局变量，不好（说到底就是返回值不是void的递归函数你都不会写！）
    int max_deep = 0;
    public void deep(TreeNode root,int deep){
        if (root == null) return;
        deep(root.left,deep+1);
        deep(root.right,deep+1);
        if (deep > max_deep) max_deep = deep;
    }

    public int maxDepth(TreeNode root) {
        deep(root,1);
        return max_deep;
    }



    //方法二：不使用全局变量
    public int maxDepth1(TreeNode root) {
        if (root == null)return 0;
        int left_deep = maxDepth1(root.left)+1;
        int right_deep = maxDepth1(root.right)+1;
        return Math.max(left_deep,right_deep);
    }
}
