package LeetCode热题100.普通数组.轮转数组;

import java.util.Arrays;

/*
189. 轮转数组
中等
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]

示例 2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]

提示：
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


进阶：

尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class Solution {

    /*
    方法一：超时，时间复杂度不好：o(k*n)
     */
    public static void rotate(int[] nums, int k) {
        k = k>nums.length ? k-nums.length : k;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length-1];
            System.out.print("i:" + i +" temp:" + temp+" ");
            for (int j = nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
            for (int j = 0;j < nums.length;j++) {
                System.out.print(" "+nums[j]);
            }
            System.out.println();
        }
    }

    /*
    方法二：让需要移动的元素每次移动k格
     */
    public static void rotate1(int[] nums, int k) {
        k = k>nums.length ? k%nums.length : k;
        int temp = 0;
        int[] temp1 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        for (int j = nums.length-1; j > k-1; j--) {
            nums[j] = nums[j-k];
        }
        for (int i = 0; i < temp1.length; i++) {
            nums[i] = temp1[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" "+nums[i]);
        }
    }

    public static void main(String[] args) {
        rotate1(new int[]{1,2,3,4,5,6,7},3);
    }

}
