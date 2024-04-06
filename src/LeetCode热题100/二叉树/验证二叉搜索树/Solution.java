package LeetCode热题100.二叉树.验证二叉搜索树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {


    //方法一（错误）：单纯判断每个节点的左右子树是否符合条件，不严谨，能举出反例
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        if (root.left!=null && root.right!=null){       //如果左右子树都不为null，则判断左右儿子的大小是否符合条件
            return isValidBST(root.left)&&isValidBST(root.right)&&(root.left.val < root.val && root.right.val > root.val);
        }else if (root.left!=null){     //如果右子树为null，则判断左子树是否符合条件，并判断左儿子的值是否符合条件
            return isValidBST(root.left)&&(root.left.val < root.val);
        }else if (root.right!=null){     //如果左子树为null，则判断右子树是否符合条件，并判断右儿子的值是否符合条件
            return isValidBST(root.right)&&(root.right.val > root.val);
        }else {     //如果左右儿子都为null，则直接返回true
            return true;
        }
    }
    //方法二：利用中序遍历，判断数组是否有序来判断
    public boolean isValidBST1(TreeNode root) {

        if (root == null || (root.left==null && root.right==null)) return true;

        Stack<TreeNode> tree_stack = new Stack<TreeNode>();
        TreeNode node = root;
        Boolean flag = true;        //标记此时是否能够将左子树入栈（如果是刚刚经历出栈，并且没有新元素入栈，则不能将左子树入栈，容易无限循环）
        //为什么要设置flag？：否则会出现问题：此时必须标记node已经出栈，否则如果没有右儿子的话，下一次循环就会执行if里的语句，再次将node入栈

        tree_stack.push(root);      //先把根入栈
        boolean flag1 = false;      //判断-2147483648有没有被遍历过
        int k = (int) (-Math.pow(2,31));
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
                if (node.val > k){
                    k = node.val;
                }else if (node.val==k && node.val==(int)(-Math.pow(2,31)) && flag1==false) { //如果第一次出现-2147483648，且k==node.val，也符合条件，但是第二次出现就不符合条件了
                    flag1 = true;
                    k = node.val;
                }else {
                    return false;
                }
                if (node.right != null) {
                    tree_stack.push(node.right);
                    flag = true;
                }
            }
        }
        return true;
    }
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
