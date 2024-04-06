package LeetCode热题100.二叉树.从前序与中序遍历序列构造二叉树;
/*
105. 从前序与中序遍历序列构造二叉树
中等
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

示例 1:
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]

提示:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列
 */
public class Solution {

    public TreeNode build(int[] preorder, int[] inorder,int pre_start,int pre_end,int in_start,int in_end) {
        if (in_start > in_end || pre_start > preorder.length-1) return null;
        int root_index = 0;
        TreeNode node = new TreeNode(preorder[pre_start]);      //创建新节点
        for (int i = 0; i < inorder.length; i++) {      //找到此节点在中序遍历序列中的位置
            if (inorder[i] == preorder[pre_start]) {
                root_index = i;
                break;
            }
        }
        // 得到左子树中的节点数目
        int size_left_subtree = root_index - in_start;
        //左子树：前序序列取[pre_start+1,root_index]      中序序列取[in_start,root_index-1]
        node.left = build(preorder,inorder,pre_start+1,pre_start+size_left_subtree,in_start,root_index-1);
        //右子树：前序序列取[root_index+1,pre_end]      中序序列取后半部分[root_index+1,in_end]
        node.right = build(preorder,inorder,pre_start+size_left_subtree+1,pre_end,root_index+1,in_end);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,preorder.length-1,0,inorder.length);

    }
}
