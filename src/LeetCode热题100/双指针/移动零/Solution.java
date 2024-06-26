package LeetCode热题100.双指针.移动零;

/*
283. 移动零
简单
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

示例 2:
输入: nums = [0]
输出: [0]

提示:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

进阶：你能尽量减少完成的操作次数吗？
 */

public class Solution {
    //边走边挪非0元素
    public void moveZeroes(int[] nums) {
        int f = 0;      //用来记录非0元素走到哪一格了
        int zero = 0;   //用来记录有多少个0
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[f++] = nums[i];
            else zero++;
        }
        for (int i = nums.length-1; i > nums.length-1-zero ; i--) {
            nums[i] = 0;
        }
    }
}
