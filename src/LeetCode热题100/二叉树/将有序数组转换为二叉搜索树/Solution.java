package LeetCode热题100.二叉树.将有序数组转换为二叉搜索树;

/*
108. 将有序数组转换为二叉搜索树
简单
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

示例 1：
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列
 */


public class Solution {

    public TreeNode build_tree(int[] nums,int start,int end){
        if (start > end){
            return null;
        }
        TreeNode root = new TreeNode(nums[(start+end)/2]);
        root.left = build_tree(nums,start,(start+end)/2 -1);
        root.right = build_tree(nums,(start+end)/2 +1,end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build_tree(nums,0,nums.length-1);
    }
}
