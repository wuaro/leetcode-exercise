package LeetCode热题100.双指针.盛水最多的容器;

/*
11. 盛最多水的容器
中等
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。

示例 1：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例 2：
输入：height = [1,1]
输出：1

提示：
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */

public class Solution {
    //暴力算法不可取
    public int maxArea(int[] height) {
        if(height.length == 1) return 0;
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int water = (j-i)*Math.min(height[i],height[j]);
                if (water > max) max = water;
            }
        }
        return max;
    }

    /*
    方法二：双指针法（妙）
    i，j分别指头和尾，每次移动i和j中较短的那一条边（期待移动之后会换成更大的边，从而增大水的面积）
    主要是移动较长的那条边没有用，水的面积是受制于短的那条边的（木桶效应）
     */
    public static int maxArea1(int[] height) {
        if(height.length == 1) return 0;
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while(i != j){
            int water = Math.min(height[i],height[j]) *(j-i);
            max = (water>max) ? water : max;
            if (height[i] > height[j]) j--;         //每次移动较短的那条边（因为水的面积受制于较短的那条边）
            else i++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea1(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
