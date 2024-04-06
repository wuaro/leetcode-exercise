package LeetCode热题100.矩阵.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;
/*
54. 螺旋矩阵
中等
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class Solution {


    //方法一：模拟路线，通过条件判断来决定是继续直走还是改变方向
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int arr[] = new int[matrix.length * matrix[0].length];
        int num = 0;        //记录已经遍历过的元素的个数
        int i = 0;          //记录当前所遍历元素的坐标
        int j = 0;
        int direction = 0;      //0：往右  1：往下  2：往左  3：往上（记录此时正往哪个方向遍历）
        while(num != matrix.length * matrix[0].length){
            list.add(matrix[i][j]);
            num++;
            matrix[i][j] = 200;             //因为-100 <= matrix[i][j] <= 100，所以置成200即可标记为已经遍历过
            if (direction == 0){
                if (j != matrix[0].length-1 && matrix[i][j+1] != 200) j++;  //如果没碰壁就继续走，碰壁了就转向接着走
                else {
                    direction = 1;
                    i++;
                }
            } else if (direction == 1) {
                if (i != matrix.length-1 && matrix[i+1][j] != 200) i++;  //如果没碰壁就继续走，碰壁了就转向接着走
                else {
                    direction = 2;
                    j--;
                }
            } else if (direction == 2) {
                if (j != 0 && matrix[i][j-1] != 200) j--;  //如果没碰壁就继续走，碰壁了就转向接着走
                else {
                    direction = 3;
                    i--;
                }
            }else {
                if (i != 0 && matrix[i-1][j] != 200) i--;  //如果没碰壁就继续走，碰壁了就转向接着走
                else {
                    direction = 0;
                    j++;
                }
            }
        }
        return list;
    }
}
