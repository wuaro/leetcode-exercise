package LeetCode热题100.矩阵.矩阵置零;
/*
73. 矩阵置零
中等
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

示例 1：
输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]

示例 2：
输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

提示：
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1

进阶：
一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？
 */


/*
  绝妙方法：用matrix数组的第0行和第0列来记录对应的列、行是否需要置0（妙极！！！）
          此时只需要设置两个flag，额外记录一下第0行和第0列有没有0（即第0行和第0列是否最终需要置0）
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag_i = false;         //定义两个标志，分别记录第0行、第0列有没有0
        boolean flag_j = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                    if (i == 0) flag_i = true;
                    if (j == 0) flag_j = true;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (flag_i){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flag_j){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}