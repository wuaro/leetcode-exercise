package LeetCode热题100.二叉树.二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
199. 二叉树的右视图
中等
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1:
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]

示例 2:
输入: [1,null,3]
输出: [1,3]

示例 3:
输入: []
输出: []

提示:
二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        //两个队列分别存储每个节点的值 和 每个节点所属第几层
        Queue<TreeNode> queue_for_val = new LinkedList<>();         //LinkedList类实现了Queue接口
        Queue<Integer> queue_for_layer = new LinkedList<>();
        int layer = 1;      //记录此时遍历到第几层
        TreeNode node = null;       //记录当前出队的节点
        TreeNode node_1 = null;       //记录前一个出队的节点
        int lay = 0;        //记录当前出队节点所属第几层
        queue_for_val.add(root);
        queue_for_layer.add(1);
        while (!queue_for_val.isEmpty()){
            node = queue_for_val.poll();       //由于poll()方法会直接把头结点去掉，所以要记录一下
            lay = queue_for_layer.poll();
            if (lay > layer){        //如果是新的一层，就建立新的list，把该节点的值加入list，并将list加入到ans中
                ans.add(node_1.val);
                layer++;
            }
            node_1 = node;      //之前出队的元素已经使用完了，可以覆盖了
            if (node.left != null){                 //左右儿子全部入队
                queue_for_val.add(node.left);
                queue_for_layer.add(lay+1);
            }
            if (node.right != null){
                queue_for_val.add(node.right);
                queue_for_layer.add(lay+1);
            }
        }
        ans.add(node_1.val);
        return ans;
    }
}
