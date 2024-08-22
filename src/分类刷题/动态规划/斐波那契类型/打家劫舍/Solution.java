package 分类刷题.动态规划.斐波那契类型.打家劫舍;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        if(nums[0] > nums[1]) nums[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-2]+nums[i],nums[i-1]);
        }
        return nums[nums.length-1];
    }
}
