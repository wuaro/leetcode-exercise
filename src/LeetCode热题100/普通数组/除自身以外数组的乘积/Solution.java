package LeetCode热题100.普通数组.除自身以外数组的乘积;
/*
238. 除自身以外数组的乘积
中等
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请不要使用除法，且在 O(n) 时间复杂度内完成此题。

示例 1:
输入: nums = [1,2,3,4]
输出: [24,12,8,6]

示例 2:
输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]

提示：
2 <= nums.length <= 105
-30 <= nums[i] <= 30
保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内

进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Solution {

    /**
     *方法一：时间O(n),空间o(n)
     * 创建L[]和R[]，分别存储第i个元素左、右侧所有元素的乘积
     * 最终answer[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int L[] = new int[nums.length];     //用于存储第i个元素之前 所有元素的乘积
        int R[] = new int[nums.length];     //用于存储第i个元素之后 所有元素的乘积
        int answer[] = new int[nums.length];
        L[0] = 1;
        R[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i-1]*nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            R[i] = R[i+1]*nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = L[i]*R[i];
        }
        return answer;
    }

    /**
     *方法二：时间O(n),空间o(1) ————在返回的answer数组不算空间复杂度的情况下
     * 不再创建L[]和R[]，改用answer数组来代替L[]，然后控制一个int变量r来取代R数组的作用
     */
    public int[] productExceptSelf1(int[] nums) {
        int answer[] = new int[nums.length];
        answer[0] = 1;
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1]*nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            r *= nums[i+1];
            answer[i] *= r;
        }
        return answer;
    }

}
