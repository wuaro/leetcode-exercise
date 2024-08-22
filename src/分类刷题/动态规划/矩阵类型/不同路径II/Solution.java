package 分类刷题.动态规划.矩阵类型.不同路径II;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int recard[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0,flag = 0; i < obstacleGrid.length; i++) {
            if (flag == 0){             //记录第一列，如果遇到障碍物，则其下面所有的位置都记录为“到达不了”
                if (obstacleGrid[i][0] == 1){
                    flag = 1;
                    recard[i][0] = 0;
                    continue;
                }
                recard[i][0] = 1;
            }else {
                recard[i][0] = 0;
            }
        }
        for (int i = 0,flag = 0; i < obstacleGrid[0].length; i++) {
            if (flag == 0){             //记录第一行，如果遇到障碍物，则其右面所有的位置都记录为“到达不了”
                if (obstacleGrid[0][i] == 1){
                    flag = 1;
                    recard[0][i] = 0;
                    continue;
                }
                recard[0][i] = 1;
            }else {
                recard[0][i] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0){
                    recard[i][j] = recard[i-1][j] + recard[i][j-1];
                }
            }
        }
        return recard[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
