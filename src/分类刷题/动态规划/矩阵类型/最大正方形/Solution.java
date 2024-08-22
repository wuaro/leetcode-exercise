package 分类刷题.动态规划.矩阵类型.最大正方形;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;     //最终要返回的值，先设置成最小值
        int record[][] = new int[matrix.length][matrix[0].length]; //对于矩阵中每个点，计算以该点为右下角的最大矩形的宽和高
        for (int i = 0; i < matrix.length; i++) {           //初始化第0列的记录，减48是因为'0'对应的int值刚好是48，要把48给减成0
            record[i][0] = matrix[i][0]-48;
            max = record[i][0]>max ? record[i][0] : max;
        }
        for (int i = 1; i < matrix[0].length; i++) {           //初始化第0行的记录
            record[0][i] = matrix[0][i]-48;
            max = record[0][i]>max ? record[0][i] : max;
        }
        /*
            record[i][i1] = Math.min(Math.min(record[i-1][i1],record[i][i1-1]),record[i-1][i1-1])+1;
            如何判断可以升级为一个边长为4的正方形？
            需要：
                1. 当前位置为'1'
                2. 在当前位置 上，左，左上 三个位置的record[i][j]都至少为3
            record[i][j]记录的是以第i行第j列位置为右下角的正方形的最大边长
         */
        for (int i = 1; i < record.length; i++) {
            for (int i1 = 1; i1 < record[0].length; i1++) {
                if (matrix[i][i1] == '1'){
                    record[i][i1] = Math.min(Math.min(record[i-1][i1],record[i][i1-1]),record[i-1][i1-1])+1;
                    max = record[i][i1]>max ? record[i][i1] : max;
                }
            }
        }
        return max*max;
    }
}
