package 分类刷题.动态规划.斐波那契类型.使用最小花费爬楼梯;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int stairs1 = 0;        //用于记录爬上当前阶梯往下数第二个阶梯的最小代价
        int stairs2 = 0;        //用于记录爬上当前阶梯的下面一个阶梯的最小代价
        int stairs3 = 0;
        for (int i = 2; i <= cost.length; i++) {
            stairs3 = Math.min(stairs1+cost[i-2],stairs2+cost[i-1]);    //在跳一格和跳两格之间选择代价最小的那个
            stairs1 = stairs2;
            stairs2 = stairs3;
        }
        return stairs3;
    }
}
