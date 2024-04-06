package LeetCode热题100.矩阵.旋转图像;
/*
48. 旋转图像
中等
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]

示例 2：
输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

提示：
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int w = matrix.length-1;          //方形矩阵中元素下标的最大值
        int temp = 0;
        int temp_1 = 0;
        /*
        如果一个元素时matrix[i][j]，那么旋转之后，会变成什么？会变成matrix[j][w-i]
         */
        int l = matrix.length;
        int ll = matrix.length-1;

        for (int i = 0; i < l/2; i++) {         //一层一层扒开，一共有l/2层需要转动
            for (int j = i; j < ll; j++) {      //每一层需要四方互换的元素都是从第i个开始到第ll个元素结束
                temp = matrix[j][w-i];          //记住“右”元素的值
                temp_1 = matrix[w-i][w-j];      //记住“下”元素的值
                matrix[j][w-i] = matrix[i][j];  //将“上”元素挪到“右”元素，“右”元素被覆盖
                matrix[w-i][w-j] = temp;        //将“右”元素挪到“下”元素，“下”元素被覆盖

                temp =  matrix[w-j][i];         //记住“左”元素的值
                matrix[w-j][i]= temp_1;         //将“下”元素挪到“左”元素，“左”元素被覆盖
                matrix[i][j] = temp;            //将“左”元素挪到“上”元素，“上”元素被覆盖
            }
            ll--;                       //每深入一层，需要4方互换的元素个数就会减少1个
        }
    }
}
