package LeetCode热题100.二叉树.二叉搜索树中第k小的元素;

import java.util.Stack;

/*
230. 二叉搜索树中第K小的元素
中等
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

示例 1：
输入：root = [3,1,4,null,2], k = 1
输出：1

示例 2：
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3

提示：
树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104

进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> tree_stack = new Stack<TreeNode>();
        TreeNode node = root;
        Boolean flag = true;        //标记此时是否能够将左子树入栈（如果是刚刚经历出栈，并且没有新元素入栈，则不能将左子树入栈，容易无限循环）
        //为什么要设置flag？：否则会出现问题：此时必须标记node已经出栈，否则如果没有右儿子的话，下一次循环就会执行if里的语句，再次将node入栈

        tree_stack.push(root);      //先把根入栈
        int num = 0;
        while (!tree_stack.empty()){
            if (tree_stack.peek().left != null && flag){        //如果左子树不为null，且上一轮出栈的元素不是该元素的左儿子，则将左儿子入栈
                tree_stack.push(tree_stack.peek().left);
            }else {
                //如果左子树为null，将自己出栈并输出，然后再将右儿子入栈（如果存在的话）
                //由于栈是先入自己，再入左儿子，所以在出栈时，如果没有右子树，则会继续操作栈中的下一个元素（出栈元素的父亲）

                //注意：此时会出现问题：此时必须标记node已经出栈，否则如果没有右儿子的话，下一次循环就会执行if里的语句，再次将node入栈
                node = tree_stack.peek();
                tree_stack.pop();
                flag = false;       //刚刚经历出栈，不能后面不能立刻入栈左子树
                num++;
                if (num == k){
                    return node.val;
                }
                if (node.right != null) {
                    tree_stack.push(node.right);
                    flag = true;
                }
            }
        }
        return 0 ;
    }
}
