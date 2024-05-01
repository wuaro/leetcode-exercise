package 分类刷题.BFS.二叉树的层序遍历II;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<List<TreeNode>> stack = new Stack<>();
        List<TreeNode> l = new ArrayList<>();
        l.add(root);
        stack.push(l);          //首先将根节点，也就是第一层放入stack中
        Boolean flag = true;    //当前还可以继续遍历

        while (flag){
            flag = false;
            List<TreeNode> list = new ArrayList<>();
            //遍历上一层所有节点的左右孩子，将当前这一层的所有非空节点存入list
            //如果有节点加入这一层的list，说明这一层有节点，说明这一层有非空节点，则while循环可以继续遍历下一层，令flag=true
            for (int i = 0; i < stack.peek().size(); i++) {
                if (stack.peek().get(i).left != null){
                    list.add(stack.peek().get(i).left);
                    flag = true;
                }
                if (stack.peek().get(i).right != null){
                    list.add(stack.peek().get(i).right);
                    flag = true;
                }
            }
            if (flag == true) {
                stack.push(list);
            }
        }

        while (!stack.empty()){
            List<TreeNode> pop = stack.pop();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < pop.size(); i++) {
                list.add(pop.get(i).val);
            }
            result.add(list);
        }
        return result;

    }
}
