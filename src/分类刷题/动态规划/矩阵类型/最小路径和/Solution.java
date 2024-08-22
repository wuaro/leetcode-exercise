package 分类刷题.动态规划.矩阵类型.最小路径和;

public class Solution {
    public int minPathSum(int[][] grid) {
        int record[][] = new int[grid.length][grid[0].length];
        record[0][0] = grid[0][0];
        for (int i = 1; i < record.length; i++) {
            record[i][0] = record[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < record[0].length; i++) {
            record[0][i] = record[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < record.length; i++) {
            for (int i1 = 1; i1 < record[0].length; i1++) {
                record[i][i1] = Math.min(grid[i][i1]+record[i-1][i1],grid[i][i1]+record[i][i1-1]);
            }
        }
        return record[grid.length-1][grid[0].length-1];
    }
}
