package LeetCode热题100.二叉树.二叉树的层序遍历;

/*
102. 二叉树的层序遍历
中等
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

示例 2：
输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]

提示：
树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue_for_val = new LinkedList<>();          //用来装结点的队列
        Queue<Integer> queue_for_layer = new LinkedList<>();        //用来装结点对应层数的队列
        int layer = 0;      //记录当前所在层数

        queue_for_val.add(root);        //先把root及其层数(1) 分别入队
        queue_for_layer.add(1);
        while(!queue_for_val.isEmpty()){                //poll()函数作用：取队头结点，并删除该结点
             TreeNode node = queue_for_val.poll();
             int lay = queue_for_layer.poll();
            if (lay > layer){        //如果是新的一层，就建立新的list，把该节点的值加入list，并将list加入到ans中
                List<Integer> l = new ArrayList<>();
                l.add(node.val);
                ans.add(l);
                layer++;
            } else if (lay == layer) {       //如果队头元素还在这一层，就正常加入
                ans.get(layer-1).add(node.val);
            }



            if (node.left != null){                 //左右儿子全部入队
                queue_for_val.add(node.left);
                queue_for_layer.add(lay+1);
            }
            if (node.right != null){
                queue_for_val.add(node.right);
                queue_for_layer.add(lay+1);
            }

        }
        return ans;
    }
}
