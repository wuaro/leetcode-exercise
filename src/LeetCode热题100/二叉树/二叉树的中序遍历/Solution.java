package LeetCode热题100.二叉树.二叉树的中序遍历;
/*
94. 二叉树的中序遍历
简单
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100

进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;




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


    //迭代法：

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        Stack<TreeNode> tree_stack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode node = root;
        Boolean flag = true;        //标记此时是否能够将左子树入栈（如果是刚刚经历出栈，并且没有新元素入栈，则不能将左子树入栈，容易无限循环）
        //为什么要设置flag？：否则会出现问题：此时必须标记node已经出栈，否则如果没有右儿子的话，下一次循环就会执行if里的语句，再次将node入栈

        tree_stack.push(root);      //先把根入栈
        while (!tree_stack.empty()){
            if (tree_stack.peek().left != null && flag){        //如果左子树不为null，且上一轮出栈的元素不是该元素的左儿子，则将左儿子入栈
                System.out.println("此时栈顶元素的值为："+tree_stack.peek().val+"此时node值为："+node.val);
                tree_stack.push(tree_stack.peek().left);
            }else {
                //如果左子树为null，将自己出栈并输出，然后再将右儿子入栈（如果存在的话）
                //由于栈是先入自己，再入左儿子，所以在出栈时，如果没有右子树，则会继续操作栈中的下一个元素（出栈元素的父亲）

                //注意：此时会出现问题：此时必须标记node已经出栈，否则如果没有右儿子的话，下一次循环就会执行if里的语句，再次将node入栈
                node = tree_stack.peek();
                tree_stack.pop();
                flag = false;       //刚刚经历出栈，不能后面不能立刻入栈左子树
                ans.add(node.val);
                System.out.println(node.val);
                if (!tree_stack.empty()) System.out.println("此时栈顶元素为："+tree_stack.peek().val);
                if (node.right != null) {
                    tree_stack.push(node.right);
                    flag = true;
                }
            }
        }
        return ans;
    }
}
