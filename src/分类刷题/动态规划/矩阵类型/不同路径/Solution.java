package 分类刷题.动态规划.矩阵类型.不同路径;

public class Solution {
    public int uniquePaths(int m, int n) {
        int recard[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    recard[i][j] = 1;
                }else {
                    recard[i][j] = recard[i-1][j] + recard[i][j-1];
                }
            }
        }
        return recard[m-1][n-1];
    }
}
