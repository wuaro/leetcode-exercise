package 分类刷题.二分法.搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a = matrix.length-1;    //行
        int b = matrix[0].length-1; //列

        while (a>=0 && b>=0){
            if (matrix[a][b]>target){
                if (a == 0){
                    b--;
                    continue;
                }else {
                    if (matrix[a-1][b]<target){
                        b--;
                        continue;
                    }else {
                        a--;
                    }
                }
            }else if (matrix[a][b]<target){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
}
