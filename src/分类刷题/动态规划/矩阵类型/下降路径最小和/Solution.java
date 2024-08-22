package 分类刷题.动态规划.矩阵类型.下降路径最小和;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = 100*100;
        int[][] record = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {    //初始化第0行
            record[0][i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {       //初始化每一行的第0个和最后一个元素
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                if (i1 == 0){
                    record[i][0] = Math.min(
                            record[i-1][0]+matrix[i][0] ,
                            record[i-1][1]+matrix[i][0]
                    );
                }else if (i1 == matrix[0].length-1){
                    record[i][matrix[i].length-1] = Math.min(
                            record[i-1][matrix[i].length-1] + matrix[i][matrix[i].length-1] ,
                            record[i-1][matrix[i].length-2] + matrix[i][matrix[i].length-1]
                    );
                }else {
                    record[i][i1] = Math.min(
                            Math.min(
                                    record[i-1][i1-1] + matrix[i][i1] ,
                                    record[i-1][i1] + matrix[i][i1]
                            ),
                            record[i-1][i1+1] + matrix[i][i1]
                    );
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            min = record[record.length-1][i] < min ? record[record.length-1][i] : min;
        }
        return min;
    }
}
