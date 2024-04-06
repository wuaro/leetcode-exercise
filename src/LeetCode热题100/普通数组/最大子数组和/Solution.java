package LeetCode热题100.普通数组.最大子数组和;
/*
53. 最大子数组和
中等
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。

示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

示例 2：
输入：nums = [1]
输出：1

示例 3：
输入：nums = [5,4,-1,7,8]
输出：23

提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104

进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */


/**
 * 法一：动态规划
 *  其实根本不用记录数组，因为只返回最大值就行
 *  设置一个变量sum，表示第i个数字结束的子数组中，最大和是多少
 *  对于第i个数来说：
 *      如果自己+sum之后变大了，那就+sum，使sum继续增大
 *      如果自己+sum之后反而变小了，则从自己开始，自己就是最大的，即sum = num[i]
 *
 *
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum+nums[i] > nums[i]){
                sum = sum+nums[i];
            }else{
                sum = nums[i];
            }
            if (sum > max) max = sum;
        }
        return max;
    }
}
