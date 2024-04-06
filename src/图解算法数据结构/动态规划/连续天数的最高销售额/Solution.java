package 图解算法数据结构.动态规划.连续天数的最高销售额;

/**
 * 连续天数的最高销售额
 * 某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。
 * 要求实现时间复杂度为 O(n) 的算法。
 *
 * 示例 1:
 * 输入：sales = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：[4,-1,2,1] 此连续四天的销售总额最高，为 6。
 *
 * 示例 2:
 * 输入：sales = [5,4,-1,7,8]
 * 输出：23
 * 解释：[5,4,-1,7,8] 此连续五天的销售总额最高，为 23。 
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {

    /**
     * 以第j天结尾的连续几天最高营业额 = max{第j天之前总营业额 - 第i天之前的总营业额}（i<j）
     * 相当于半个穷举法，不好！
     */
//    public static int maxSales(int[] sales) {
//        if (sales.length == 1) return sales[0];
//        int M = sales[0];       //记录最高营业额
//        //将数组改为记录：第i天之前的总营业额
//        //顺便记录单日最高营业额
//        for (int i = 1; i < sales.length; i++) {
//            M = Math.max(M,sales[i]);
//            sales[i] += sales[i-1];
//            M = Math.max(M,sales[i]);
//        }
//        int[][] dp = new int[][]{};
//        //从sales[1]开始，依次计算sales[j]-sales[i]
//        for (int j = 1; j < sales.length; j++) {
//            for (int i = 0; i < j; i++) {
//                M = Math.max(M,sales[j]-sales[i]);
//            }
//        }
//        return M;
//    }


    /**
     * 以第j天结尾的连续几天最高营业额dp[j]:
     *  如果dp[j-1]<0: 说明dp[j-1]对dp[j] 产生负贡献，即dp[j−1]+sales[j] 还不如直接用sales[j]来的大
     *      则dp[j] = sales[j]
 *      如果dp[j-1]>0:
     *      则dp[j] = dp[j-1]+sales[j]
     *
     * 注：可以不创建dp[]数组，直接在sales[]数组上操作，这样能省下空间！
     */
    public static int maxSales(int[] sales) {
        int M = sales[0];
        for (int i = 1; i < sales.length; i++) {
            if (sales[i-1] <= 0){
                M = Math.max(M,sales[i]);
            }else {
                sales[i] = sales[i-1]+sales[i];
                M = Math.max(M,sales[i]);
            }
        }
        return M;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,4,-1,7,8};
        System.out.println(maxSales(a));
    }

}
